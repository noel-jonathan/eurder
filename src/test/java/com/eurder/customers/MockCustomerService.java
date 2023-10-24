package com.eurder.customers;

import jakarta.enterprise.inject.Alternative;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Alternative
public class MockCustomerService extends CustomerService{
    public MockCustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        super(mock(CustomerRepository.class), mock(CustomerMapper.class));
    }

    @Override
    public CustomerDto create(CreateCustomerDto createCustomerDto){
        CustomerDto customerDtoMock = mock(CustomerDto.class);

        when(customerDtoMock.getId()).thenReturn("1111");
        when(customerDtoMock.getFirstName()).thenReturn("John");
        when(customerDtoMock.getLastName()).thenReturn("Doe");
        when(customerDtoMock.getEmail()).thenReturn("<EMAIL>");

        return customerDtoMock;
    }
}
