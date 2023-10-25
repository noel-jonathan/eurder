package com.eurder.orders;

import com.eurder.items.Item;

import java.time.LocalDate;
import java.util.UUID;

public class ItemOrder {
    private final String id;
    private final Item item;
    private final int quantity;
    private final LocalDate shippingDate;

    public ItemOrder(Item item, int quantity, LocalDate shippingDate) {
        this.id = UUID.randomUUID().toString();
        this.item = item;
        this.quantity = quantity;
        this.shippingDate = shippingDate;
    }

    public String getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
