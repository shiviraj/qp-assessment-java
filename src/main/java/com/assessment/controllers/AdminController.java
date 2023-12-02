package com.assessment.controllers;

import com.assessment.controllers.views.DeleteResponse;
import com.assessment.controllers.views.ProductQuantityRequest;
import com.assessment.models.Product;
import com.assessment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{productId}")
    public DeleteResponse deleteProduct(@PathVariable Long productId) {
        Optional<Product> product = productService.getProductByProductId(productId);
        if (product.isPresent()) {
            productService.deleteProductById(productId);
        }
        return new DeleteResponse(product.isPresent());
    }

    @PutMapping("/products/{productId}")
    public Optional<Product> updateProductDetails(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        return productService.updateProductDetails(productId, updatedProduct);
    }

    @PatchMapping("/products/{productId}/inventory")
    public Optional<Product> updateProductInventory(@PathVariable Long productId, @RequestBody ProductQuantityRequest productQuantity) {
        return productService.updateProductInventory(productId, productQuantity.quantity);
    }
}


