package com.example.orderservice.service;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderItem;
import java.util.List;

import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service.user}")
    private String USER_SERVICE;
    @Value("${service.food}")
    private String FOOD_SERVICE;
    public Order createOrder(Long userId, List<OrderItem> items) {
        // Validate user
        ResponseEntity<Object> userResponse = restTemplate.getForEntity(USER_SERVICE + "/" + userId, Object.class);
        if (userResponse.getStatusCode().is2xxSuccessful() == false) {
            throw new RuntimeException("User not found");
        }
        // Validate foods & calculate total
        double total = 0;
        for (OrderItem item : items) {
            ResponseEntity<Object> foodResponse = restTemplate.getForEntity(FOOD_SERVICE + "/" + item.getFoodId(), Object.class);
            if (foodResponse.getStatusCode().is2xxSuccessful() == false) {
                throw new RuntimeException("Food not found: " + item.getFoodId());
            }
            // Parse price (simplified)
            total += item.getQuantity() * item.getPrice();
        }
        Order order = new Order();
        order.setUserId(userId);
       // order.setItems(items);
        order.setTotal(total);
        return orderRepository.save(order);
    }
    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
    public Order updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(status);
        return orderRepository.save(order);
    }
}

