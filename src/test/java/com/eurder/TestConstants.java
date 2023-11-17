package com.eurder;

import com.eurder.customers.CreateCustomerDto;
import com.eurder.customers.Customer;
import com.eurder.customers.CustomerDto;
import com.eurder.items.Item;
import com.eurder.items.ItemDto;

public class TestConstants {
    public static final Long CUSTOMER_ID = 123456789L;
    public static final CreateCustomerDto CREATE_CUSTOMER_DTO = new CreateCustomerDto(
            "John",
            "password",
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
            CUSTOMER.id,
            "John",
            "Doe",
            "<EMAIL>"
    );
    public static final Long ITEM_ID = 987654321L;

    public static final Item ITEM = new Item(
            "name",
            "description",
            19.99,
            5
    );
    public static final ItemDto ITEM_DTO = new ItemDto(
            ITEM_ID,
            "name",
            "description",
            19.99,
            5
    );
}
