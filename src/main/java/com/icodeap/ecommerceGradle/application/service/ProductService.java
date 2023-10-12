package com.icodeap.ecommerceGradle.application.service;

import com.icodeap.ecommerceGradle.application.repository.ProductRepository;
import com.icodeap.ecommerceGradle.domain.Identifier;
import com.icodeap.ecommerceGradle.domain.Product;
import com.icodeap.ecommerceGradle.domain.User;

import java.time.LocalDateTime;

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

        if(product.getId() == null ){

            User user = User.builder().identifier(Identifier.of(1)).build();

            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUser(user);
            return this.productRepository.saveProduct(product);
        }else{
            Product productDB = productRepository.getProductById(product.getId());
            product.setCode(productDB.getCode());
            product.setUser(productDB.getUser());
            product.setDateCreated(productDB.getDateCreated());
            product.setDateUpdated(LocalDateTime.now());

            return productRepository.saveProduct(product);
        }
    }

    public void deleteProductById(Integer id){
        this.productRepository.deleteProductById(id);
    }

}
