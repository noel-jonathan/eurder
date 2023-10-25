package com.eurder.customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import static com.eurder.customers.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerService = new CustomerService(customerRepository, customerMapper);

        when(customerMapper.mapToEntity(CREATE_CUSTOMER_DTO)).thenReturn(CUSTOMER);
        customerService.create(CREATE_CUSTOMER_DTO);
    }

    @Test
    void testCreateCustomer() {

        verify(customerRepository).add(CUSTOMER);
        verify(customerMapper).mapToEntity(CREATE_CUSTOMER_DTO);
        verify(customerMapper).mapToDto(CUSTOMER);
    }

    @Test
    void testGetAll() {

        customerService.getAll();

        verify(customerRepository).getCustomers();
        verify(customerMapper).mapToDto(CUSTOMER);
    }

     @Test
    void testGetCustomer() {
        when(customerRepository.getCustomer(CUSTOMER_ID)).thenReturn(CUSTOMER);

        customerService.get(CUSTOMER_ID);

        verify(customerRepository).getCustomer(CUSTOMER_ID);
        verify(customerMapper, times(2)).mapToDto(CUSTOMER);
     }
}
