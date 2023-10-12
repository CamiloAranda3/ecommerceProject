package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class ProductImageTest {

    @Test
    void productImageTestCorrect(){

        //Arrange
        String productImageTest = "productImage";

        //Act
        ProductImage productImage = new ProductImage(productImageTest);
        String currentProductImage = ProductImage.of(productImageTest).getValue();

        //Assert
        Assertions.assertNotNull(currentProductImage);
        Assertions.assertEquals(currentProductImage, productImageTest);
    }

    @Test
    void productImageTestIsNull(){

        //Arrange
        String expectedProductImageTest = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                ()->ProductImage.of(expectedProductImageTest),
                "ProductImage must have a value"
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(),InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("ProductImage must have a value"));

    }
}
