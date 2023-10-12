package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class ProductNameTest {

    @Test
    void productNameTestCorrect(){

        //Arrange
        String productNameTest = "productName";

        //Act
        ProductName productName = new ProductName(productNameTest);
        String currentProductName = ProductName.of(productNameTest).getValue();

        //Assert
        Assertions.assertNotNull(currentProductName);
        Assertions.assertEquals(currentProductName, productNameTest);
    }

    @Test
    void productNameTestIsNull(){

        //Arrange
        String expectedProductNameTest = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                ()->ProductName.of(expectedProductNameTest),
                "ProductName must have a value"
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(),InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("ProductName must have a value"));

    }
}
