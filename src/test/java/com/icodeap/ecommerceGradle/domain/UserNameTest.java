package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class UserNameTest {

    @Test
    void userNameCorrect(){

        //Arrange
        String userNameTest = "userName";

        //Act
        UserName userName = new UserName(userNameTest);
        String currentUserName = UserName.of(userNameTest).getValue();

        //Assert
        Assertions.assertNotNull(currentUserName);
        Assertions.assertEquals(currentUserName,userNameTest);
    }

    @Test
    void userNameIsNull(){

        //Arrange
        String expectedUserName = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                () ->UserName.of(expectedUserName),
                "UserName must have a value"
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(), InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("UserName must have a value"));
    }

}
