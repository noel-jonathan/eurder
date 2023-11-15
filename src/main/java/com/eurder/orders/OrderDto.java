package com.eurder.orders;

import com.eurder.customers.CustomerDto;

public record OrderDto(CustomerDto customer, ItemOrderGroup itemOrderGroup, double total) {

}
