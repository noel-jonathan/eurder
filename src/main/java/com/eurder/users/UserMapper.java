package com.eurder.users;

import com.eurder.customers.CreateCustomerDto;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserMapper {
    public UserDto toDto(User user) {
        return new UserDto(
                user.email,
                user.role
        );
    }

    public User toEntity(CreateCustomerDto createCustomerDto) {
        User user = new User();
        user.email = createCustomerDto.email();
        user.password = createCustomerDto.password();
        return user;
    }
}
