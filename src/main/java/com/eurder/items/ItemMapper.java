package com.eurder.items;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemMapper {
    public ItemDto toDto(Item item) {
        return new ItemDto(
                item.id,
                item.name,
                item.description,
                item.price,
                item.stock
        );
    }
}
