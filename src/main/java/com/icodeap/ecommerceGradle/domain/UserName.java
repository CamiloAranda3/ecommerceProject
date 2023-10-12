package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class UserName {

    private final String value;

    public UserName(String value) {

        //if(StringUtils.isEmpty(value)){
           // throw new InvalidParameterException("UserName must have a value");
       // }

        this.value = value;
    }

    public static UserName of(String value){return new UserName(value);}
}
