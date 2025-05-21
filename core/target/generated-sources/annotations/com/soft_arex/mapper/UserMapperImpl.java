package com.soft_arex.mapper;

import com.soft_arex.entity.User;
import com.soft_arex.user.model.UserCreateRequest;
import com.soft_arex.user.model.UserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-21T11:14:56+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserCreateRequest userCreateRequest) {
        if ( userCreateRequest == null ) {
            return null;
        }

        User user = new User();

        user.setPassword( userCreateRequest.getPassword() );
        user.setEmail( userCreateRequest.getEmail() );
        user.setPhone( userCreateRequest.getPhone() );
        user.setFirstName( userCreateRequest.getFirstName() );
        user.setLastName( userCreateRequest.getLastName() );
        user.setRole( userCreateRequest.getRole() );

        return user;
    }

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setEmail( user.getEmail() );
        userResponse.setPhone( user.getPhone() );
        userResponse.setFirstName( user.getFirstName() );
        userResponse.setLastName( user.getLastName() );
        userResponse.setRole( user.getRole() );

        return userResponse;
    }
}
