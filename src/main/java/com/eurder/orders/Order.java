package com.eurder.orders;

import com.eurder.customers.Customer;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "eurder")
public class Order extends PanacheEntity {

    @ManyToOne
    @NotNull
    @JoinColumn(name = "fk_customer")
    public Customer customer;
    @Embedded
    @NotNull
    public ItemOrderGroup itemOrderGroup;
    @Min(0)
    @Column(name = "total_price")
    public double totalPrice;

    public Order(Customer customer, ItemOrderGroup itemOrderGroup) {
        this.customer = customer;
        this.itemOrderGroup = itemOrderGroup;
        this.totalPrice = calculateTotalPrice();
    }

    public Order() {

    }

    private double calculateTotalPrice() {
        double itemPrice = this.itemOrderGroup.getItem().price;
        int itemQuantity = this.itemOrderGroup.getAmount();
        return itemPrice * itemQuantity;
    }

}
