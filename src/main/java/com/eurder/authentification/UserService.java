package com.eurder.authentification;

import com.eurder.customers.CreateCustomerDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserDto registerAdmin(User user) {
        user.role = "admin";
        User.add(user.email, user.password, user.role);
        return userMapper.toDto(user);
    }

    public void registerCustomer(CreateCustomerDto createCustomerDto) {
        User user = userMapper.toEntity(createCustomerDto);
        user.role = "customer";
        User.add(user.email, user.password, user.role);
    }
}
