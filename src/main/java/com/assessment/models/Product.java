package com.assessment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String name;
    private Integer quantity;
    private double price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void updateDetails(Product updatedProduct) {
        if (updatedProduct.name != null) {
            this.name = updatedProduct.name;
        }
        if (updatedProduct.quantity != null) {
            this.quantity = updatedProduct.quantity;
        }
        this.price = updatedProduct.price;
    }

    public void addQuantity(Integer quantity) {
        this.quantity += quantity;
    }
}
