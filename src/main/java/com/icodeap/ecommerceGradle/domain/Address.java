package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class Address {

    private final String value;

    public Address(String value) {

        if(StringUtils.isEmpty(value)){
            throw new InvalidParameterException("Address must have a value");
        }

        this.value = value;
    }

    public static Address of(String value){return new Address(value);}
}
