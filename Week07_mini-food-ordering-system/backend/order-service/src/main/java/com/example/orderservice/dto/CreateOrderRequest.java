package com.example.orderservice.dto;
import com.example.orderservice.model.OrderItem;
import java.util.List;
public class CreateOrderRequest {
    private Long userId;
    private List<OrderItem> items;
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}

