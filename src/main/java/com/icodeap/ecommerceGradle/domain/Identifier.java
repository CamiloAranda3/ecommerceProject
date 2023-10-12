package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.security.InvalidParameterException;

@EqualsAndHashCode
@Getter
public class Identifier {

    private final Integer value;


    public Identifier(Integer value) {

        if (value == null){
            throw new InvalidParameterException("Identifier must be greater than 0.");
        }

        this.value = value;
    }

    public static Identifier of(Integer value){ return new Identifier(value);}
}
