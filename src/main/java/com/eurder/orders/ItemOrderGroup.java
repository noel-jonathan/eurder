package com.eurder.orders;

import com.eurder.items.Item;

import java.time.LocalDate;
import java.util.UUID;

public class ItemOrderGroup {
    public static final int DAYS_TO_ADD_WHEN_IN_STOCK = 1;
    public static final int DAYS_TO_ADD_WHEN_NOT_IN_STOCK = 7;
    private final String id;
    private final Item item;
    private final int amount;
    private final LocalDate shippingDate;

    public ItemOrderGroup(Item item, int amount) {
        this.id = UUID.randomUUID().toString();
        this.item = item;
        this.amount = amount;
        this.shippingDate = calculateShippingDate();
    }

    private LocalDate calculateShippingDate() {
        if (this.item.getStock() < this.amount) {
            return LocalDate.now().plusDays(DAYS_TO_ADD_WHEN_NOT_IN_STOCK);
        }
        return LocalDate.now().plusDays(DAYS_TO_ADD_WHEN_IN_STOCK);
    }

    public String getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
