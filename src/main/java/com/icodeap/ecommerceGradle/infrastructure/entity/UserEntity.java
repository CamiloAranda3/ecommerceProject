package com.icodeap.ecommerceGradle.infrastructure.entity;

import com.icodeap.ecommerceGradle.domain.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  userName;
    private String  firstName;
    private String  lastName;
    private String  email;
    private String  address;
    private String  cellPhone;
    private String  password;
    @Enumerated(EnumType.STRING)//Se mapea el campo a tipo string
    private UserType userType;
    private LocalDateTime dateCreated;
}
