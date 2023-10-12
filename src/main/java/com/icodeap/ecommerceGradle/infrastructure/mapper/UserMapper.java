package com.icodeap.ecommerceGradle.infrastructure.mapper;

import com.icodeap.ecommerceGradle.domain.User;
import com.icodeap.ecommerceGradle.infrastructure.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            // Se mapea del source userEntity a el target User
          @Mapping(source = "id", target = "identifier"),
          @Mapping(source = "userName", target= "userName"),
          @Mapping(source = "firstName", target= "firstName"),
          @Mapping(source = "lastName", target= "lastName"),
          @Mapping(source = "email", target= "email"),
          @Mapping(source = "address", target= "address"),
          @Mapping(source = "cellPhone", target= "cellPhone"),
          @Mapping(source = "password", target= "password"),
          @Mapping(source = "userType", target= "userType"),
          @Mapping(source = "dateCreated", target= "dateCreated")
    })
    //Se mapea de userEntity a User, para no mezclar las tablas de la bd con las clases de dominio
    User toUser(UserEntity userEntity);

    //Metodo que devuelve una lista de Users
    Iterable<User> toUser(Iterable<UserEntity> userEntities);

    //Metodo que devuelve una lista de userEntities
    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);

}
