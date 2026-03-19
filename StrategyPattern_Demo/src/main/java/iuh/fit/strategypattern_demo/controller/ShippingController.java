package iuh.fit.strategypattern_demo.controller;

import iuh.fit.strategypattern_demo.service.ShippingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShippingController {

    private final ShippingService service;

    public ShippingController(ShippingService service) {
        this.service = service;
    }

    @GetMapping("/shipping")
    public String shipping(@RequestParam String type, @RequestParam double amount) {
        double fee = service.calculate(type, amount);
        return "Shipping type: " + type + ", order amount: " + amount + ", fee: " + fee;
    }
}