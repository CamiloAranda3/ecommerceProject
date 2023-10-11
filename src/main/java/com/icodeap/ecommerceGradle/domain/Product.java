package com.icodeap.ecommerceGradle.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@ToString
public class Product {
    private Integer id;
    private String code;
    private String name;
    private String description;
    private String image;
    private BigDecimal price;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    private User user;

    public Product(){
        /*Cada vez que se instancie una objeto vacío, se crea con un único código */
        this.setCode(UUID.randomUUID().toString());
    }
}
