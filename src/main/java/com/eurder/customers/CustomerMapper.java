package com.eurder.customers;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerMapper {
    public CustomerDto mapToDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }

    public Customer mapToEntity(CreateCustomerDto createCustomerDto) {
        return new Customer(
                createCustomerDto.getFirstName(),
                createCustomerDto.getLastName(),
                createCustomerDto.getEmail(),
                createCustomerDto.getAddress(),
                createCustomerDto.getPhoneNumber()
        );
    }
}
