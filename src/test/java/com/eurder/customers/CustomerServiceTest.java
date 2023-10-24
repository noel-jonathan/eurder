package com.eurder.customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        CreateCustomerDto createCustomerDto = new CreateCustomerDto(
                "John",
                "Doe",
                "<EMAIL>",
                "Address",
                "123456789"
        );
        Customer customer = new Customer(
                "John",
                "Doe",
                "<EMAIL>",
                "Address",
                "123456789"
        );
        CustomerDto customerDto = new CustomerDto(
                customer.getId(),
                "John",
                "Doe",
                "<EMAIL>"
        );

        Mockito.when(customerMapper.mapToEntity(createCustomerDto)).thenReturn(customer);
        Mockito.when(customerMapper.mapToDto(customer)).thenReturn(customerDto);

        CustomerDto result = customerService.create(createCustomerDto);

        Mockito.verify(customerRepository).add(customer);
        assertEquals(customer.getId(), result.getId());
    }
}
