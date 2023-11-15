package com.eurder.customers;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Customer extends PanacheEntity {

    @Column(name = "first_name")
    @NotEmpty
    public String firstName;
    @Column(name = "last_name")
    @NotEmpty
    public String lastName;
    @Column(name = "address")
    @NotEmpty
    public String address;
    @Column(name = "email", unique = true)
    @NotEmpty
    public String email;
    @Column(name = "phone_number", unique = true)
    @NotEmpty
    public String phoneNumber;

    public Customer(String firstName, String lastName, String email, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {

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
