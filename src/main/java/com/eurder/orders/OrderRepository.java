package com.eurder.orders;

import java.util.HashMap;

public class OrderRepository {
    private HashMap<String, Order> orders = new HashMap<>();

    public void add(Order order) {
        orders.put(order.getId(), order);
    }
}
