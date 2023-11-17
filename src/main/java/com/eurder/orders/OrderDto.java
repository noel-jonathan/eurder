package com.eurder.orders;

import com.eurder.customers.CustomerDto;

import java.util.List;

public record OrderDto(CustomerDto customer, ItemOrderGroup itemOrderGroup, double total) {

}
