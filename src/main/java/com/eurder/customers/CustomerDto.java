package com.eurder.customers;

public class CustomerDto {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;

    public CustomerDto(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
