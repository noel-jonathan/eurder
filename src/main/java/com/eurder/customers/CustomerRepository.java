package com.eurder.customers;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;

@ApplicationScoped
public class CustomerRepository {
    private HashMap<String, Customer> customers = new HashMap<>();

    public HashMap<String, Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomer(String id) {
        return customers.get(id);
    }

    public Customer addCustomer(Customer customer) {
        return customers.put(customer.getId(), customer);
    }
}
