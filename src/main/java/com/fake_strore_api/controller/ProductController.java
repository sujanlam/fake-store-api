package com.fake_strore_api.controller;

import com.fake_strore_api.model.Product;
import com.fake_strore_api.service.product.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productServiceImpl.getAllProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable int productId){
        return ResponseEntity.ok(productServiceImpl.fetchProductbyId(productId));

    }
}
