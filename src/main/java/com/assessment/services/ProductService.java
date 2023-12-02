package com.assessment.services;

import com.assessment.models.Product;
import com.assessment.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    public Optional<Product> getProductByProductId(Long productId) {
        return productRepository.findById(productId);
    }

    public Optional<Product> updateProductDetails(Long productId, Product updatedProduct) {
        Optional<Product> productOptional = getProductByProductId(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.updateDetails(updatedProduct);
            productRepository.save(product);
        }
        return productOptional;
    }

    public Optional<Product> updateProductInventory(Long productId, Integer quantity) {
        Optional<Product> productOptional = getProductByProductId(productId);
        if(productOptional.isPresent()){
            Product product =productOptional.get();
            product.addQuantity(quantity);
            productRepository.save(product);
        }
        return productOptional;
    }
}
