package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class ProductImage {

    private final String value;

    public ProductImage(String value) {

        if(StringUtils.isEmpty(value)){
            throw new InvalidParameterException("ProductImage must have a value");
        }

        this.value = value;
    }

    public static ProductImage of(String value){return new ProductImage(value);}
}
