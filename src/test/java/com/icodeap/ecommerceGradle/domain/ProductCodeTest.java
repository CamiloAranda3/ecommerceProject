package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class ProductCodeTest {

    @Test
    void productCodeTestCorrect(){

        //Arrange
        String productCodeTest = "productCode";

        //Act
        ProductCode productCode = new ProductCode(productCodeTest);
        String currentProductCode = ProductCode.of(productCodeTest).getValue();

        //Assert
        Assertions.assertNotNull(currentProductCode);
        Assertions.assertEquals(currentProductCode, productCodeTest);
    }

    @Test
    void productCodeTestIsNull(){

        //Arrange
        String expectedProductCodeTest = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                ()->ProductCode.of(expectedProductCodeTest),
                "ProductCode must have a value"
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(),InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("ProductCode must have a value"));

    }
}
