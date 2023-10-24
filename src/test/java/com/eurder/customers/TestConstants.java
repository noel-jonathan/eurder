package com.eurder.customers;

public class TestConstants {
    public static final String CUSTOMER_ID = "123456789";
    public static final CreateCustomerDto CREATE_CUSTOMER_DTO = new CreateCustomerDto(
            "John",
            "Doe",
            "<EMAIL>",
            "Address",
            "123456789"
    );
    public static final Customer CUSTOMER = new Customer(
            "John",
            "Doe",
            "<EMAIL>",
            "Address",
            "123456789"
    );

    public static final CustomerDto CUSTOMER_DTO = new CustomerDto(
            CUSTOMER.getId(),
            "John",
            "Doe",
            "<EMAIL>"
    );

}
