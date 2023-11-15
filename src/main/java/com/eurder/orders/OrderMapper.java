package com.eurder.orders;

import com.eurder.customers.CustomerMapper;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderMapper {
    private final CustomerMapper customerMapper;

    public OrderMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public OrderDto toDto(Order order){
        return new OrderDto(
                customerMapper.toDto(order.customer),
                order.itemOrderGroup,
                order.totalPrice
        );
    };
}
