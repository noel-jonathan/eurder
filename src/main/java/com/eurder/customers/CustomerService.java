package com.eurder.customers;

import com.eurder.users.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class CustomerService {
    private final CustomerMapper customerMapper;
    private final UserService userService;
    public CustomerService(CustomerMapper customerMapper, UserService userService) {
        this.customerMapper = customerMapper;
        this.userService = userService;
    }

    public CustomerDto register(CreateCustomerDto createCustomerDto) {
        userService.registerCustomer(createCustomerDto);

        Customer customerToAdd = customerMapper.toEntity(createCustomerDto);
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
