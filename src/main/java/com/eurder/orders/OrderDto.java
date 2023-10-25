package com.eurder.orders;

import com.eurder.customers.CustomerDto;

public record OrderDto(String id, CustomerDto customer, ItemOrderGroup itemOrderGroup, double total) {

}
