package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class ProductDescription {

    private final String value;

    public ProductDescription(String value) {

        if(StringUtils.isEmpty(value)){
            throw new InvalidParameterException("ProductDescription must have a value");
        }

        this.value = value;
    }

    public static ProductDescription of(String value){return new ProductDescription(value);}
}
