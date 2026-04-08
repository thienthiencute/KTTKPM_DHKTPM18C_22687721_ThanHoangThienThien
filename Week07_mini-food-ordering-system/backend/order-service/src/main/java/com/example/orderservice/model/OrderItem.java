package com.example.orderservice.model;
import jakarta.persistence.*;
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    private Long foodId;
    private int quantity;
    private double price;
    public OrderItem() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getFoodId() { return foodId; }
    public void setFoodId(Long foodId) { this.foodId = foodId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

