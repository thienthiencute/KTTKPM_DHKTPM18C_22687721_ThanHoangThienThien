package com.example.foodservice.controller;
import com.example.foodservice.model.Food;
import com.example.foodservice.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/foods")
@CrossOrigin("*")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;
    @GetMapping
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFood(@PathVariable Long id) {
        return foodRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Food createFood(@RequestBody Food food) {
        return foodRepository.save(food);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food foodDetails) {
        return foodRepository.findById(id)
                .map(food -> {
                    food.setName(foodDetails.getName());
                    food.setPrice(foodDetails.getPrice());
                    food.setDescription(foodDetails.getDescription());
                    return ResponseEntity.ok(foodRepository.save(food));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        if (foodRepository.existsById(id)) {
            foodRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

