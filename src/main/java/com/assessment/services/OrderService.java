package com.assessment.services;

import com.assessment.controllers.views.OrderRequest;
import com.assessment.models.Order;
import com.assessment.models.OrderProduct;
import com.assessment.models.Product;
import com.assessment.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;


    public Order placeOrder(OrderRequest orderRequest) {
        ArrayList<OrderProduct> orderProducts = new ArrayList<>();
        orderRequest.products.forEach(orderProduct -> {
                    Optional<Product> optionalProduct = productService.getProductByProductId(orderProduct.getProductId());
                    if (optionalProduct.isPresent()) {
                        Product product = optionalProduct.get();
                        OrderProduct orderProduct1 = new OrderProduct(product.getId(), orderProduct.getQuantity());
                        orderProduct1.updateSubtotal(product.getPrice());
                        orderProducts.add(orderProduct1);
                    }
                }
        );
        Order order = new Order();
        order.setProducts(orderProducts);
        return orderRepository.save(order);
    }
}
