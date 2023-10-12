package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class Email {

    private final String value;

    public Email(String value) {

        if(StringUtils.isEmpty(value)){
            throw new InvalidParameterException("Email must have a value");
        }

        this.value = value;
    }

    public static Email of(String value){return new Email(value);}
}
