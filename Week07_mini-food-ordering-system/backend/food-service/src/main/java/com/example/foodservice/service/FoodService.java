package com.example.foodservice.service;
import com.example.foodservice.model.Food;
import com.example.foodservice.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
@Service
public class FoodService implements CommandLineRunner {
    @Autowired
    private FoodRepository foodRepository;
    @Override
    public void run(String... args) throws Exception {
        if (foodRepository.count() == 0) {
            foodRepository.save(new Food("Phở bò", 50000, "Phở truyền thống"));
            foodRepository.save(new Food("Bánh mì", 20000, "Bánh mì pate"));
            foodRepository.save(new Food("Cơm tấm", 45000, "Sườn nướng"));
            foodRepository.save(new Food("Bún chả", 40000, "Obama bowl"));
            foodRepository.save(new Food("Gỏi cuốn", 30000, "Tôm thịt"));
            System.out.println("Seeded 5 foods");
        }
    }
}

