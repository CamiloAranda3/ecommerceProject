package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class ProductId {
    private final Integer value;


    public ProductId(Integer value) {

        if (value == null){
            throw new InvalidParameterException("ProductId must be greater than 0.");
        }

        this.value = value;
    }

    public static ProductId of(Integer value){ return new ProductId(value);}
}
