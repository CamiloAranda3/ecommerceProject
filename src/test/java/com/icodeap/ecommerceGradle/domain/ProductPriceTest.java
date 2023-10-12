package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

public class ProductPriceTest {

    @Test
    void ProductPriceTestIsValid() {

        //Arrange
        BigDecimal expectedProductPrice = BigDecimal.valueOf(10);

        //Act
        ProductPrice.of(expectedProductPrice);
        BigDecimal currentProductPrice = ProductPrice.of(expectedProductPrice).getValue();

        //Assert
        Assertions.assertNotNull(currentProductPrice);
        Assertions.assertEquals(currentProductPrice, expectedProductPrice);

    }

    @Test
    void ProductPriceTestIsNull() {

        //Arrange
        BigDecimal expectedProductPriceTest = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                () -> ProductPrice.of(expectedProductPriceTest)
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(), InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("ProductPrice must be greater than 0"));

    }
}
