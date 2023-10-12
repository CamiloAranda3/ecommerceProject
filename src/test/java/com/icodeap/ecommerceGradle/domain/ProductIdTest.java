package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class ProductIdTest {

    @Test
    void ProductIdTestIsValid() {

        //Arrange
        Integer expectedProductId = Integer.valueOf(10);

        //Act
        Identifier.of(expectedProductId);
        Integer actualIdentifier = Identifier.of(expectedProductId).getValue();

        //Assert
        Assertions.assertNotNull(actualIdentifier);
        Assertions.assertEquals(actualIdentifier, expectedProductId);

    }

    @Test
    void ProductIdTestIsNull() {

        //Arrange
        Integer expectedProductIdTest = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                () -> ProductId.of(expectedProductIdTest)
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(), InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("ProductId must be greater than 0"));

    }
}
