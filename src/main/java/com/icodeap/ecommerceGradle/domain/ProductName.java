package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;
import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class ProductName {

    private final String value;

    public ProductName(String value) {

        if(StringUtils.isEmpty(value)){
            throw new InvalidParameterException("ProductName must have a value");
        }

        this.value = value;
    }

    public static ProductName of(String value){return new ProductName(value);}
}
