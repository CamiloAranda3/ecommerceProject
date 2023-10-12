package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class ProductPrice {

    private final BigDecimal value;


    public ProductPrice(BigDecimal value) {

        if (value == null){
            throw new InvalidParameterException("ProductPrice must be greater than 0.");
        }

        this.value = value;
    }

    public static ProductPrice of(BigDecimal value){ return new ProductPrice(value);}
}
