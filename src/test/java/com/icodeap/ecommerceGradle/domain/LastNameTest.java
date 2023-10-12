package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class LastNameTest {

    @Test
    void LastNameCorrect(){

        //Arrange
        String lastNameTest = "lastName";

        //Act
        LastName lastName = new LastName(lastNameTest);
        String currentLastName = LastName.of(lastNameTest).getValue();

        //Assert
        Assertions.assertNotNull(currentLastName);
        Assertions.assertEquals(currentLastName,lastNameTest);
    }

    @Test
    void LastNameIsNull(){

        //Arrange
        String expectedLastName = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                ()->LastName.of(expectedLastName),
                "LastName must have a value"
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(),InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("LastName must have a value"));
    }
}
