package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class EmailTest {

    @Test
    void EmailCorrect(){

        //Arrange
        String emailTest = "email";

        //Act
        Email email = new Email(emailTest);
        String currentEmail = Email.of(emailTest).getValue();

        //Assert
        Assertions.assertNotNull(currentEmail);
        Assertions.assertEquals(currentEmail,emailTest);
    }

    @Test
    void emailIsNull(){

        //Arrange
        String expectedEmail = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                () ->Email.of(expectedEmail),
                "Email must have a value"
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(), InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("Email must have a value"));
    }

}
