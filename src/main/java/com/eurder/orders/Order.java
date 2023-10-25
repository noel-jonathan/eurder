package com.eurder.orders;

import com.eurder.customers.Customer;

import java.util.HashMap;
import java.util.UUID;

public class Order {
    private final String id;
    private final Customer customer;
    private final ItemOrder itemOrder;
    private final double totalPrice;

    public Order(Customer customer, ItemOrder itemOrder, double totalPrice) {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.itemOrder = itemOrder;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ItemOrder getItemOrder() {
        return itemOrder;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
