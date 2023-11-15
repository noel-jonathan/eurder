package com.eurder.authentification;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserMapper {
    public UserDto toDto(User user) {
        return new UserDto(
                user.email,
                user.role
        );
    }
}
