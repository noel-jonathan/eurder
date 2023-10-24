package com.eurder.customers;

public class CreateCustomerDto {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

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

    public CreateCustomerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateCustomerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateCustomerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateCustomerDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public CreateCustomerDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
