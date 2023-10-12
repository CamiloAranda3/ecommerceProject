package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

public class ProductDateCreatedTest {

    @Test
    void productDateCreatedIsValid(){

        //Arrange
        LocalDateTime expectedProductDateCreated = LocalDateTime.now().minusDays(1);

        //Act
        ProductDateCreated.of(expectedProductDateCreated);
        LocalDateTime currentDateCreated = ProductDateCreated.of(expectedProductDateCreated).getValue();

        //Assert
        Assertions.assertNotNull(currentDateCreated);
        Assertions.assertEquals(expectedProductDateCreated,currentDateCreated);
    }

    @Test
    void productDateCreatedIsNull(){

        //Arrange
        LocalDateTime expectedProductDateCreated = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                () -> ProductDateCreated.of(expectedProductDateCreated)
        );

        //Assert
        Assertions.assertEquals(InvalidParameterException.class, thrown.getClass());
        Assertions.assertTrue(thrown.getMessage().contains("ProductDateCreated must have a value"));
    }

    @Test
    void productDateCreatedIsNotValid(){

        //Arrange
        LocalDateTime expectedDateCreated = LocalDateTime.now().plusDays(1);

        //Act
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ProductDateCreated.of(expectedDateCreated)
        );

        //Assert
        Assertions.assertEquals(IllegalArgumentException.class, thrown.getClass());
        Assertions.assertTrue(thrown.getMessage().contains("ProductDateCreated cannot be greater than now"));
    }
}
