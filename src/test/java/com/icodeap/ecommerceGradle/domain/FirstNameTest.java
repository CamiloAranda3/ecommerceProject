package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class FirstNameTest {

    @Test
    void FirstNameCorrect(){

        //Arrange
        String firstNameTest = "firstName";

        //Act
        FirstName firstName = new FirstName(firstNameTest);
        String currentFirstName = FirstName.of(firstNameTest).getValue();

        //Assert
        Assertions.assertNotNull(currentFirstName);
        Assertions.assertEquals(currentFirstName, firstNameTest);
    }

    @Test
    void firstNameIsNull(){

        //Arrange
        String expectedFirstName = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                ()->FirstName.of(expectedFirstName),
                "FirstName must have a value"
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(),InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("FirstName must have a value"));

    }
}
