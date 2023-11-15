package com.eurder.orders;

import com.eurder.customers.Customer;
import com.eurder.items.Item;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class OrderService {
    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public OrderDto create(CreateOrderDto createOrderDto) {

        Customer foundCustomer = Customer.findById(createOrderDto.customerId());
        Item foundItem = Item.findById(createOrderDto.itemId());
        int amount = createOrderDto.amount();

        if (foundItem.stock < amount) {
            throw new IllegalArgumentException(String.format("Current stock (%d) is not enough to fulfill order", amount));
        }

        Order order = new Order(
                foundCustomer,
                new ItemOrderGroup(foundItem, amount));

        Order.persist(order);
        foundItem.decreaseStock(amount);
        Item.persist(foundItem);
        return orderMapper.toDto(order);
    }

}
