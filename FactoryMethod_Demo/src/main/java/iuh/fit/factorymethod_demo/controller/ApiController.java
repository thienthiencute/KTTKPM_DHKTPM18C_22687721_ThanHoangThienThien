package iuh.fit.factorymethod_demo.controller;

import iuh.fit.factorymethod_demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final OrderService orderService;

    public ApiController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public String createOrder(@RequestParam String type) {
        return orderService.createOrder(type);
    }
}
