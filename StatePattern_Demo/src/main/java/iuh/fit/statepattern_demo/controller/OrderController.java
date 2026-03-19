package iuh.fit.statepattern_demo.controller;

import iuh.fit.statepattern_demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/next")
    public String nextState() {
        return orderService.nextOrderState();
    }
}
