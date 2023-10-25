package com.eurder.orders;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;

@ApplicationScoped
public class OrderRepository {
    private HashMap<String, Order> orders = new HashMap<>();

    public void add(Order order) {
        orders.put(order.getId(), order);
    }
}
