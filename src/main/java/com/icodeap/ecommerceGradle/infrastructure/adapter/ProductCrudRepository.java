package com.icodeap.ecommerceGradle.infrastructure.adapter;

import com.icodeap.ecommerceGradle.domain.Product;
import com.icodeap.ecommerceGradle.infrastructure.entity.ProductEntity;
import com.icodeap.ecommerceGradle.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity,Integer> {
    Iterable<ProductEntity> findByUserEntity(UserEntity userEntity);
}
