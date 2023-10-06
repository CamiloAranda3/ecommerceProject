package com.icodeap.ecommerceGradle.infrastructure.configuration;

import com.icodeap.ecommerceGradle.application.repository.ProductRepository;
import com.icodeap.ecommerceGradle.application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository){
        return new ProductService(productRepository);
    }
}
