package com.eurder.orders;

public record CreateOrderDto(String customerId, CreateOrderGroupDto orderGroup) {
}
