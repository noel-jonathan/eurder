package com.eurder.orders;

import com.eurder.customers.Customer;
import com.eurder.customers.CustomerRepository;
import com.eurder.items.Item;
import com.eurder.items.ItemRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ItemRepository itemRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDto create(CreateOrderDto createOrderDto) {
        Customer customer = customerRepository.getCustomer(createOrderDto.customerId());
        Item item = itemRepository.getItem(createOrderDto.orderGroup().itemId());
        int quantity = createOrderDto.orderGroup().quantity();
        Order order = new Order(
                customer,
                new ItemOrderGroup(item, quantity)
        );
        orderRepository.add(order);
        return orderMapper.toDto(order);
    }

}
