package com.eurder.customers;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.NoSuchElementException;

@ApplicationScoped
public class CustomerRepository {
    private HashMap<String, Customer> customers = new HashMap<>();

    public HashMap<String, Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomer(String id) {
        if (!customers.containsKey(id)) {
            throw new NoSuchElementException("No customer with id " + id + " found");
        }
        return customers.get(id);
    }

    public Customer add(Customer customer) {
        return customers.put(customer.getId(), customer);
    }
}
