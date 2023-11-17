package com.eurder.customers;

public record CreateCustomerDto(String email, String password, String firstName, String lastName, String address, String phoneNumber) {
}
