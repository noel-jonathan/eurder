package com.eurder.customers;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto createCustomer(CreateCustomerDto createCustomerDto) {
        Customer customer = customerMapper.mapToEntity(createCustomerDto);
        return customerMapper.mapToDto(customerRepository.addCustomer(customer));
    }
}
