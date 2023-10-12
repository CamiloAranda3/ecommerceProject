package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class AddressTest {

    @Test
    void addressCorrect(){

        //Arrange
        String addressTest = "address";

        //Act
        Address address = new Address(addressTest);
        String currentAddress = Address.of(addressTest).getValue();

        //Assert
        Assertions.assertNotNull(currentAddress);
        Assertions.assertEquals(currentAddress,addressTest);
    }

    @Test
    void addressIsNull(){

        //Arrange
        String expectedAddress = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                () ->Address.of(expectedAddress),
                "Address must have a value"
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(), InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("Address must have a value"));
    }
}
