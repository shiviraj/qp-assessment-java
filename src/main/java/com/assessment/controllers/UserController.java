package com.assessment.controllers;

import com.assessment.controllers.views.DeleteResponse;
import com.assessment.controllers.views.OrderRequest;
import com.assessment.controllers.views.ProductQuantityRequest;
import com.assessment.models.Order;
import com.assessment.models.Product;
import com.assessment.services.OrderService;
import com.assessment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;


    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/order")
    public Order placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }


}


