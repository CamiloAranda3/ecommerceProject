package com.icodeap.ecommerceGradle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
public class DateCreated {

    private final LocalDateTime value;

    public DateCreated(LocalDateTime value){

            if(value  == null){
                throw new InvalidParameterException("DateCreated must have a value");
            }

            if(value.isAfter(LocalDateTime.now())){
                throw new IllegalArgumentException("DateCreated cannot be greater than now");
            }

            this.value = value;
    }

    public static DateCreated of(LocalDateTime value){ return new DateCreated(value);}
}
