package com.eurder.customers;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerMapper {
    public CustomerDto toDto(Customer customer) {
        return new CustomerDto(
                customer.id,
                customer.firstName,
                customer.lastName,
                customer.email
        );
    }

    public Customer toEntity(CreateCustomerDto createCustomerDto) {
        return new Customer(
                createCustomerDto.email(),
                createCustomerDto.firstName(),
                createCustomerDto.lastName(),
                createCustomerDto.address(),
                createCustomerDto.phoneNumber()
        );
    }
}
