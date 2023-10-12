package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class PasswordTest {

    @Test
    void passwordCorrect(){

        //Arrange
        String passwordTest = "password";

        //Act
        Password password = new Password(passwordTest);
        String currentPassword = Password.of(passwordTest).getValue();

        //Assert
        Assertions.assertNotNull(currentPassword);
        Assertions.assertEquals(currentPassword,passwordTest);
    }

    @Test
    void passwordIsNull(){

        //Arrange
        String expectedPassword = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                () ->Password.of(expectedPassword),
                "Password must have a value"
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(), InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("Password must have a value"));
    }
}
