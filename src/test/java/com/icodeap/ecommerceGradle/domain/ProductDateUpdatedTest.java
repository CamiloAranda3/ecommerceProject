package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

public class ProductDateUpdatedTest {

    @Test
    void productDateUpdatedIsValid(){

        //Arrange
        LocalDateTime expectedProductDateUpdated = LocalDateTime.now().minusDays(1);

        //Act
        ProductDateCreated.of(expectedProductDateUpdated);
        LocalDateTime currentDateUpdated = ProductDateUpdated.of(expectedProductDateUpdated).getValue();

        //Assert
        Assertions.assertNotNull(currentDateUpdated);
        Assertions.assertEquals(expectedProductDateUpdated,currentDateUpdated);
    }

    @Test
    void productDateUpdatedIsNull(){

        //Arrange
        LocalDateTime expectedProductDateUpdated = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                () -> ProductDateUpdated.of(expectedProductDateUpdated)
        );

        //Assert
        Assertions.assertEquals(InvalidParameterException.class, thrown.getClass());
        Assertions.assertTrue(thrown.getMessage().contains("ProductDateUpdated must have a value"));
    }

    @Test
    void productDateUpdatedIsNotValid(){

        //Arrange
        LocalDateTime expectedDateUpdated = LocalDateTime.now().plusDays(1);

        //Act
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ProductDateUpdated.of(expectedDateUpdated)
        );

        //Assert
        Assertions.assertEquals(IllegalArgumentException.class, thrown.getClass());
        Assertions.assertTrue(thrown.getMessage().contains("ProductDateUpdated cannot be greater than now"));
    }
}
