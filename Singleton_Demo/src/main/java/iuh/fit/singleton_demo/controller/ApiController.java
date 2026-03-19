package iuh.fit.singleton_demo.controller;

import org.springframework.web.bind.annotation.*;
import iuh.fit.singleton_demo.service.OrderService;
import iuh.fit.singleton_demo.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final UserService userService;
    private final OrderService orderService;

    public ApiController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/user")
    public String createUser(@RequestParam String name) {
        return userService.createUser(name);
    }

    @GetMapping("/order")
    public String createOrder(@RequestParam String name) {
        return orderService.createOrder(name);
    }
}
