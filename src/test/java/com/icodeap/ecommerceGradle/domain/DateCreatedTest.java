package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;

public class DateCreatedTest {

    @Test
    void dateCreatedIsValid(){

        //Arrange
        LocalDateTime expectedDateCreated = LocalDateTime.now().minusDays(1);

        //Act
        DateCreated.of(expectedDateCreated);
        LocalDateTime currentDateCreated = DateCreated.of(expectedDateCreated).getValue();

        //Assert
        Assertions.assertNotNull(currentDateCreated);
        Assertions.assertEquals(expectedDateCreated,currentDateCreated);
    }

    @Test
    void dateCreatedIsNull(){

        //Arrange
        LocalDateTime expectedDateCreated = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                () -> DateCreated.of(expectedDateCreated)
        );

        //Assert
        Assertions.assertEquals(InvalidParameterException.class, thrown.getClass());
        Assertions.assertTrue(thrown.getMessage().contains("DateCreated must have a value"));
    }

    @Test
    void dateCreatedIsNotValid(){

        //Arrange
        LocalDateTime expectedDateCreated = LocalDateTime.now().plusDays(1);

        //Act
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> DateCreated.of(expectedDateCreated)
        );

        //Assert
        Assertions.assertEquals(IllegalArgumentException.class, thrown.getClass());
        Assertions.assertTrue(thrown.getMessage().contains("DateCreated cannot be greater than now"));
    }
}
