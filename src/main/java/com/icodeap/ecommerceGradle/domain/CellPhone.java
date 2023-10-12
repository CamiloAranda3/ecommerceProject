package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class CellPhone {

    private final String value;

    public CellPhone(String value) {

        if(StringUtils.isEmpty(value)){
            throw new InvalidParameterException("CellPhone must have a value");
        }

        this.value = value;
    }

    public static CellPhone of(String value){return new CellPhone(value);}
}
