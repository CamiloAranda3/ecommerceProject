package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;
import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class ProductCode {
    private final String value;

    public ProductCode(String value) {

        if(StringUtils.isEmpty(value)){
            throw new InvalidParameterException("ProductCode must have a value");
        }

        this.value = value;
    }

    public static ProductCode of(String value){return new ProductCode(value);}

}
