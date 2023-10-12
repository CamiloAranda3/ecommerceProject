package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class LastName {

    private final String value;

    public LastName(String value) {

        if(StringUtils.isEmpty(value)){
            throw new InvalidParameterException("LastName must have a value");
        }

        this.value = value;
    }

    public static LastName of(String value){return new LastName(value);}
}
