package iuh.fit.factoryabstract_demo.controller;

import iuh.fit.factoryabstract_demo.service.MealService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/meal")
    public String orderMeal(@RequestParam String type) {
        return mealService.orderMeal(type);
    }
}
