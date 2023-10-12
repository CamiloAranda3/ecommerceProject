package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class FirstName {
    private final String value;

    public FirstName(String value) {

        if(StringUtils.isEmpty(value)){
            throw new InvalidParameterException("FirstName must have a value");
        }

        this.value = value;
    }

    public static FirstName of(String value){return new FirstName(value);}
}
