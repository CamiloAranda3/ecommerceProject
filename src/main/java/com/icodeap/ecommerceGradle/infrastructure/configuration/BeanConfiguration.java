package com.icodeap.ecommerceGradle.infrastructure.configuration;

import com.icodeap.ecommerceGradle.application.repository.ProductRepository;
import com.icodeap.ecommerceGradle.application.service.ProductService;
import com.icodeap.ecommerceGradle.domain.Product;
import com.icodeap.ecommerceGradle.domain.User;
import com.icodeap.ecommerceGradle.infrastructure.adapter.ProductCrudRepository;
import com.icodeap.ecommerceGradle.infrastructure.adapter.ProductRepositoryImpl;
import com.icodeap.ecommerceGradle.infrastructure.entity.ProductEntity;
import com.icodeap.ecommerceGradle.infrastructure.entity.UserEntity;
import com.icodeap.ecommerceGradle.infrastructure.mapper.ProductMapper;
import com.icodeap.ecommerceGradle.infrastructure.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository){
        return new ProductService(productRepository);
    }

    @Bean
    public ProductRepositoryImpl productRepository(ProductCrudRepository productCrudRepository, ProductMapper productMapper, UserMapper userMapper){
        return new ProductRepositoryImpl(productCrudRepository,productMapper,userMapper);
    }

    @Bean
    public ProductMapper productMapper(){
        return new ProductMapper() {
            @Override
            public Product toProduct(ProductEntity productEntity) {
                return null;
            }

            @Override
            public Iterable<Product> toProducts(Iterable<ProductEntity> productEntities) {
                return null;
            }

            @Override
            public ProductEntity toProductEntity(Product product) {
                return null;
            }
        };

    }

    @Bean
    public UserMapper userMapper(){
        return new UserMapper() {
            @Override
            public User toUser(UserEntity userEntity) {
                return null;
            }

            @Override
            public Iterable<User> toUser(Iterable<UserEntity> userEntities) {
                return null;
            }

            @Override
            public UserEntity toUserEntity(User user) {
                return null;
            }
        };
    }
}
