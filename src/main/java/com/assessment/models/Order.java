package com.assessment.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private double totalAmount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderProduct> products;

    public double getTotalAmount() {
        return totalAmount;
    }

    public Long getId() {
        return id;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
        this.totalAmount = this.products.stream()
                .map(OrderProduct::getSubtotal)
                .reduce(0d, Double::sum);
    }
}
