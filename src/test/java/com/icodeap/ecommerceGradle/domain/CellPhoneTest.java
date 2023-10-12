package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class CellPhoneTest {
    @Test
    void cellPhoneCorrect(){

        //Arrange
        String cellPhoneTest = "cellPhone";

        //Act
        CellPhone cellPhone = new CellPhone(cellPhoneTest);
        String currentCellPhone = CellPhone.of(cellPhoneTest).getValue();

        //Assert
        Assertions.assertNotNull(currentCellPhone);
        Assertions.assertEquals(currentCellPhone,cellPhoneTest);
    }

    @Test
    void cellPhoneIsNull(){

        //Arrange
        String expectedCellPhone = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                () ->CellPhone.of(expectedCellPhone),
                "CellPhone must have a value"
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(), InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("CellPhone must have a value"));
    }
}
