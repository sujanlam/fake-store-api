package com.fake_strore_api.service.product;

import com.fake_strore_api.model.Product;
import com.fake_strore_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

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

    @Override
    public Product createNewProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateExistingProduct(int productId, Product product) {
        return productRepository.findById(productId)
                .map(existingProduct -> {
                    existingProduct.setCategory(product.getCategory());
                    existingProduct.setTitle(product.getTitle());
                    existingProduct.setPrice(product.getPrice());
                    existingProduct.setImage(product.getImage());
                    existingProduct.setDescription(product.getDescription());

                    return productRepository.save(existingProduct);
                })
                .orElseThrow(() -> new RuntimeException("Product Not found: " + productId));
    }

    @Override
    public void deleteProductById(int productId) {
        boolean product = productRepository.existsById(productId);
        if (product) {
            productRepository.deleteById(productId);
        } else {
            throw new RuntimeException("Product Not found: " + productId);
        }
    }

}


