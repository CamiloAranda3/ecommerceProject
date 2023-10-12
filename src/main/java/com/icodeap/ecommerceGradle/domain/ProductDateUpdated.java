package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
public class ProductDateUpdated {

    private final LocalDateTime value;

    public ProductDateUpdated(LocalDateTime value){

        if(value  == null){
            throw new InvalidParameterException("ProductDateUpdated must have a value");
        }

        if(value.isAfter(LocalDateTime.now())){
            throw new IllegalArgumentException("ProductDateUpdated cannot be greater than now");
        }

        this.value = value;
    }

    public static ProductDateUpdated of(LocalDateTime value){ return new ProductDateUpdated(value);}
}
