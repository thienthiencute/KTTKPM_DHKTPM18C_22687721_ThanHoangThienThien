package com.example.foodservice.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Min(0)
    private double price;
    private String description;
    public Food() {}
    public Food(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    // Getters Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

