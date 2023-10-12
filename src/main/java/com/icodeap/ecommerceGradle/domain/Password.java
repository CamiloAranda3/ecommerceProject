package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class Password {

    private final String value;

    public Password(String value) {

        if(StringUtils.isEmpty(value)){
            throw new InvalidParameterException("Password must have a value");
        }

        this.value = value;
    }

    public static Password of(String value){return new Password(value);}
}
