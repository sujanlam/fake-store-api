package com.fake_strore_api.service.product;


import com.fake_strore_api.model.Product;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();

    Optional<Product> fetchProductbyId(int productId);

    Product createNewProduct(Product product);

    Product updateExistingProduct(int productId, Product product);


    void deleteProductById(int productId);
}
