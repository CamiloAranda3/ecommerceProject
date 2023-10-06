package com.icodeap.ecommerceGradle.application.service;

import com.icodeap.ecommerceGradle.application.repository.ProductRepository;
import com.icodeap.ecommerceGradle.domain.Product;
import com.icodeap.ecommerceGradle.domain.User;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getProducts(){
        return this.productRepository.getProducts();
    }

    public Iterable<Product> getProductByUser(User user){
        return this.productRepository.getProductsByUser(user);
    }

    public Product getProductById(Integer id){
        return this.productRepository.getProductById(id);
    }

    public Product saveProduct(Product product){
        return this.productRepository.saveProduct(product);
    }

    public void deleteProductById(Integer id){
        this.productRepository.deleteProductById(id);
    }

}
