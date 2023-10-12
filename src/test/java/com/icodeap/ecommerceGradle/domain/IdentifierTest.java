package com.icodeap.ecommerceGradle.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class IdentifierTest {
    @Test
    void identifierTestIsValid() {

        //Arrange
        Integer expectedIdentifier = Integer.valueOf(10);

        //Act
        Identifier.of(expectedIdentifier);
        Integer actualIdentifier = Identifier.of(expectedIdentifier).getValue();

        //Assert
        Assertions.assertNotNull(actualIdentifier);
        Assertions.assertEquals(actualIdentifier, expectedIdentifier);

    }

    @Test
    void identifierTestIsNull() {

        //Arrange
        Integer expectedIdentifier = null;

        //Act
        InvalidParameterException thrown = Assertions.assertThrows(
                InvalidParameterException.class,
                () -> Identifier.of(expectedIdentifier)
        );

        //Assert
        Assertions.assertEquals(thrown.getClass(), InvalidParameterException.class);
        Assertions.assertTrue(thrown.getMessage().contains("Identifier must be greater than 0"));

    }
}
