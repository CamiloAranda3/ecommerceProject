package com.icodeap.ecommerceGradle.infrastructure.configuration;

import com.icodeap.ecommerceGradle.application.repository.ProductRepository;
import com.icodeap.ecommerceGradle.application.service.ProductService;
import com.icodeap.ecommerceGradle.domain.*;
import com.icodeap.ecommerceGradle.infrastructure.adapter.ProductCrudRepository;
import com.icodeap.ecommerceGradle.infrastructure.adapter.ProductRepositoryImpl;
import com.icodeap.ecommerceGradle.infrastructure.entity.ProductEntity;
import com.icodeap.ecommerceGradle.infrastructure.entity.UserEntity;
import com.icodeap.ecommerceGradle.infrastructure.mapper.ProductMapper;
import com.icodeap.ecommerceGradle.infrastructure.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

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
                Product product = new Product();

                product.setId(productEntity.getId());
                product.setCode(productEntity.getCode());
                product.setName(productEntity.getName());
                product.setDescription(productEntity.getDescription());
                product.setPrice(productEntity.getPrice());
                product.setUser(userMapper().toUser(productEntity.getUserEntity()));
                product.setDateCreated(productEntity.getDateCreated());
                product.setDateUpdated(productEntity.getDateUpdated());

                return product;
            }

            @Override
            public Iterable<Product> toProducts(Iterable<ProductEntity> productEntities) {

                ArrayList<Product> products = new ArrayList<>();

                for (ProductEntity productEntity: productEntities) {
                        products.add(toProduct(productEntity));
                }
                return products;
            }

            @Override
            public ProductEntity toProductEntity(Product product) {

                UserEntity userEntity = new UserEntity();
                userEntity.setId(product.getUser().getIdentifier());

                ProductEntity productEntity= new ProductEntity();

                productEntity.setId(product.getId());
                productEntity.setCode(product.getCode());
                productEntity.setName(product.getName());
                productEntity.setDescription(product.getDescription());
                productEntity.setPrice(product.getPrice());
                productEntity.setDateCreated(product.getDateCreated());
                productEntity.setDateUpdated(product.getDateUpdated());
                productEntity.setUserEntity(userEntity);

                return productEntity;
            }
        };

    }

    @Bean
    public UserMapper userMapper(){
        return new UserMapper() {
            @Override
            public User toUser(UserEntity userEntity) {

                return User.builder()
                        .identifier(Identifier.of(userEntity.getId()))
                        .username(UserName.of(userEntity.getUserName()))
                        .firstName(FirstName.of(userEntity.getFirstName()))
                        .lastName(LastName.of(userEntity.getLastName()))
                        .email(Email.of(userEntity.getEmail()))
                        .address(Address.of(userEntity.getEmail()))
                        .cellPhone(CellPhone.of(userEntity.getCellPhone()))
                        .password(Password.of(userEntity.getPassword()))
                        .dateCreated(DateCreated.of(userEntity.getDateCreated()))
                        .build();
            }

            @Override
            public Iterable<User> toUser(Iterable<UserEntity> userEntities) {
                return null;
            }

            @Override
            public UserEntity toUserEntity(User user) {
                UserEntity userEntity = new UserEntity();

                userEntity.setId(user.getIdentifier());
                System.out.println(userEntity.getId());
                userEntity.setUserName(user.getUserName());
                System.out.println(userEntity.getUserName());
                userEntity.setFirstName(user.getFirstName());
                System.out.println(userEntity.getFirstName());
                userEntity.setLastName(user.getLastName());
                userEntity.setEmail(user.getEmail());
                userEntity.setAddress(user.getAddress());
                userEntity.setCellPhone(user.getCellPhone());
                userEntity.setPassword(user.getPassword());
                //userEntity.setUserType(user.getUserType());
                userEntity.setDateCreated(user.getDateCreated());


                return userEntity;
            }
        };
    }
}
