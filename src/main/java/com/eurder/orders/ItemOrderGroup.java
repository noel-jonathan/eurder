package com.eurder.orders;

import com.eurder.items.Item;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Embeddable
public class ItemOrderGroup {
    public static final int DAYS_TO_ADD_WHEN_IN_STOCK = 1;
    public static final int DAYS_TO_ADD_WHEN_NOT_IN_STOCK = 7;

    @OneToOne
    @JoinColumn(name = "fk_item")
    public Item item;
    public int amount;
    @Column(name = "shipping_date")
    public LocalDate shippingDate;

    public ItemOrderGroup(Item item, int amount) {
        this.item = item;
        this.amount = amount;
        this.shippingDate = calculateShippingDate();
    }

    public ItemOrderGroup() {

    }

    private LocalDate calculateShippingDate() {
        if (this.item.stock < this.amount) {
            return LocalDate.now().plusDays(DAYS_TO_ADD_WHEN_NOT_IN_STOCK);
        }
        return LocalDate.now().plusDays(DAYS_TO_ADD_WHEN_IN_STOCK);
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
