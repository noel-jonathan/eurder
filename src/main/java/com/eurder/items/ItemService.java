package com.eurder.items;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class ItemService {
    private final ItemMapper itemMapper;
    public ItemService(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public ItemDto get(String id) {
        return itemMapper.toDto(Item.findById(id));
    }

    public List<ItemDto> getItems() {
        List<Item> items = Item.listAll();
        return items.stream()
                .map(itemMapper::toDto)
                .collect(Collectors.toList());
    }

    public ItemDto add(Item item) {

        Item.persist(item);
        Item.flush();
        return itemMapper.toDto(item);
    }
}
