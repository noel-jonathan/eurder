package com.eurder.customers;

import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.UUID;

public class Customer {
    private final Logger logger = Logger.getLogger(Customer.class);
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final String phoneNumber;

    public Customer(String firstName, String lastName, String email, String address, String phoneNumber) {
        this.id = String.valueOf(UUID.randomUUID().toString());
        this.firstName = validate("First name" , firstName);
        this.lastName = validate("Last name" , lastName);
        this.email = validate("Email" , email);
        this.address = validate("Address" , address);
        this.phoneNumber = validate("Phone number" , phoneNumber);
    }

    public String validate(String fieldName, String string) {
        if (string == null || string.isEmpty()) {
            String errorMessage = fieldName + " not filled in";
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        return string;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
