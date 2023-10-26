package com.eurder.customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.eurder.TestConstants.*;
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

        when(customerMapper.toEntity(CREATE_CUSTOMER_DTO)).thenReturn(CUSTOMER);
        customerService.create(CREATE_CUSTOMER_DTO);
    }

    @Test
    void testCreateCustomer() {

        verify(customerRepository).add(CUSTOMER);
        verify(customerMapper).toEntity(CREATE_CUSTOMER_DTO);
        verify(customerMapper).toDto(CUSTOMER);
    }

    @Test
    void testGetAll() {

        customerService.getAll();

        verify(customerRepository).getCustomers();
        verify(customerMapper).toDto(CUSTOMER);
    }

     @Test
    void testGetCustomer() {
        when(customerRepository.getCustomer(CUSTOMER_ID)).thenReturn(CUSTOMER);

        customerService.get(CUSTOMER_ID);

        verify(customerRepository).getCustomer(CUSTOMER_ID);
        verify(customerMapper, times(2)).toDto(CUSTOMER);
     }
}
