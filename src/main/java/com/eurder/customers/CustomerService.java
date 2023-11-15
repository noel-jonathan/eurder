package com.eurder.customers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class CustomerService {
    private final CustomerMapper customerMapper;
    public CustomerService(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public CustomerDto register(Customer customerToAdd) {
        Customer.persist(customerToAdd);
        Customer.flush();
        return customerMapper.toDto(customerToAdd);
    }

    public List<CustomerDto> getAll() {
        List<Customer> customers = Customer.listAll();
        return customers.stream()
              .map(customerMapper::toDto)
              .collect(Collectors.toList());
    }

    public CustomerDto get(Long id) {
        Customer foundCustomer = Customer.findById(id);
        if (foundCustomer == null) {
            throw new NotFoundException("Customer not found for id " + id);
        }
        return customerMapper.toDto(foundCustomer);
    }

}
