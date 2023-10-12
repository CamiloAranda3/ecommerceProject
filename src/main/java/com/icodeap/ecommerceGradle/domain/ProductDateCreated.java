package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
public class ProductDateCreated {

    private final LocalDateTime value;

    public ProductDateCreated(LocalDateTime value){

        if(value  == null){
            throw new InvalidParameterException("ProductDateCreated must have a value");
        }

        if(value.isAfter(LocalDateTime.now())){
            throw new IllegalArgumentException("ProductDateCreated cannot be greater than now");
        }

        this.value = value;
    }

    public static ProductDateCreated of(LocalDateTime value){ return new ProductDateCreated(value);}
}
