package com.eurder.customers;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto create(CreateCustomerDto createCustomerDto) {
        Customer customer = customerMapper.toEntity(createCustomerDto);
        customerRepository.add(customer);
        return customerMapper.toDto(customer);
    }

    public Set<CustomerDto> getAll() {
        return customerRepository.getCustomers().values().stream()
              .map(customerMapper::toDto)
              .collect(Collectors.toSet());
    }

    public CustomerDto get(String id) {
        return customerMapper.toDto(customerRepository.getCustomer(id));
    }
}
