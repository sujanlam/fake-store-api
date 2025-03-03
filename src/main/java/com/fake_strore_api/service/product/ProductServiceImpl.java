package com.fake_strore_api.service.product;

import com.fake_strore_api.model.Product;
import com.fake_strore_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> fetchProductbyId(int productId) {
        return Optional.ofNullable(productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + productId)));
    }
}
