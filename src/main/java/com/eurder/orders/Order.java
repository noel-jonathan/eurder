package com.eurder.orders;

import com.eurder.customers.Customer;

import java.util.UUID;

public class Order {
    private final String id;
    private final Customer customer;
    private final ItemOrderGroup itemOrderGroup;
    private final double totalPrice;

    public Order(Customer customer, ItemOrderGroup itemOrderGroup) {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.itemOrderGroup = itemOrderGroup;
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        double itemPrice = this.itemOrderGroup.getItem().getPrice();
        int itemQuantity = this.itemOrderGroup.getAmount();
        return itemPrice * itemQuantity;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ItemOrderGroup getItemOrder() {
        return itemOrderGroup;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
