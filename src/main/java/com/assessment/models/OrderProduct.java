package com.assessment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Integer quantity;
    private double subtotal;

    public OrderProduct(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderProduct() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public Long getId() {
        return id;
    }

    public void updateSubtotal(double price) {
        this.subtotal = quantity * price;
    }
}
