package iuh.fit.decorator_pattern.controller;

import iuh.fit.decorator_pattern.decorator.Order;
import iuh.fit.decorator_pattern.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/order/decorator")
    public String decoratedOrder() {
        Order order = service.createBasicOrder();
        order = service.addGiftWrap(order);       // thêm gói quà
        order = service.addExtraTopping(order);   // thêm topping

        return "Description: " + order.getDescription() +
                ", Total cost: " + order.getCost();
    }
}
