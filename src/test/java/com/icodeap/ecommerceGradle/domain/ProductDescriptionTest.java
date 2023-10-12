package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class ProductDescriptionTest {

    @Test
    void productDescriptionTestCorrect(){

        //Arrange
        String productDescriptionTest = "productDescription";

        //Act
        ProductDescription productDescription = new ProductDescription(productDescriptionTest);
        String currentProductName = ProductDescription.of(productDescriptionTest).getValue();

        //Assert
        Assertions.assertNotNull(currentProductName);
        Assertions.assertEquals(currentProductName, productDescriptionTest);
    }

    @Test
    void productDescriptionTestIsNull(){

        //Arrange
        String expectedProductDescriptionTest = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                ()->ProductDescription.of(expectedProductDescriptionTest),
                "ProductDescription must have a value"
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(),InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("ProductDescription must have a value"));

    }
}
