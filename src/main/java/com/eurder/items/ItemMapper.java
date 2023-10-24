package com.eurder.items;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemMapper {
    public ItemDto toDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getQuantity()
        );
    }

    public Item toEntity(ItemDto itemDto) {
        return new Item(
                itemDto.getName(),
                itemDto.getDescription(),
                itemDto.getPrice(),
                itemDto.getQuantity()
        );
    }
}
