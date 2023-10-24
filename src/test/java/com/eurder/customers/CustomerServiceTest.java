package com.eurder.customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.eurder.customers.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    }

    @Test
    void testCreateCustomer() {
        when(customerMapper.mapToEntity(CREATE_CUSTOMER_DTO)).thenReturn(CUSTOMER);

        customerService.create(CREATE_CUSTOMER_DTO);

        verify(customerRepository).add(CUSTOMER);
        verify(customerMapper).mapToEntity(CREATE_CUSTOMER_DTO);
        verify(customerMapper).mapToDto(CUSTOMER);
    }
}
