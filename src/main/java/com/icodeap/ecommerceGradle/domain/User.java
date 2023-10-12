package com.icodeap.ecommerceGradle.domain;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public class User {
    private final Identifier identifier;
    private final UserName username;
    private final  FirstName firstName;
    private final  LastName lastName;
    private final  Email email;
    private final  Address address;
    private final  CellPhone cellPhone;
    private final  Password password;
   // private final UserType userType;
    private final DateCreated dateCreated;


    public User(Identifier identifier, UserName username, FirstName firstName, LastName lastName, Email email, Address address, CellPhone cellPhone, Password password, DateCreated dateCreated) {
        this.identifier = identifier;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.cellPhone = cellPhone;
        this.password = password;
        //this.userType = userType;
        this.dateCreated = dateCreated;
    }

    public Integer getIdentifier() { return identifier.getValue();}
    public String getUserName() { return username.getValue();}
    public String getFirstName() { return firstName.getValue();}
    public String getLastName(){ return lastName.getValue();}
    public String getEmail() { return email.getValue();}
    public String getAddress() { return address.getValue();}
    public String getCellPhone() { return cellPhone.getValue();}
    public String getPassword() { return password.getValue();}
    //public String getUserType() { return userType.toString();}
    public LocalDateTime getDateCreated() { return dateCreated.getValue();}


}
