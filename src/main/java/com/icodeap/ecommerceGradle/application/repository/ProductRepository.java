package com.icodeap.ecommerceGradle.application.repository;

import com.icodeap.ecommerceGradle.domain.Product;
import com.icodeap.ecommerceGradle.domain.User;

public interface ProductRepository {
    Iterable<Product> getProducts();
    Iterable<Product> getProductsByUser(User user);
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProductById(Integer id);
}
