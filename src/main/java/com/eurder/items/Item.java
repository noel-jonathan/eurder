package com.eurder.items;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.jboss.logging.Logger;

import java.util.UUID;

@Entity
public class Item extends PanacheEntity {

    @NotEmpty(message = "Item name must not be empty")
    @Column(unique = true)
    public String name;
    @NotEmpty(message = "Item description must not be empty")
    public String description;
    @Min(0)
    public double price;
    @Min(0)
    public int stock;

    public Item(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Item() {

    }

    public void decreaseStock(int amount) {
        this.stock -= amount;
    }
}
