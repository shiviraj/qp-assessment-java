package com.assessment.services;

import com.assessment.repositories.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;
}
