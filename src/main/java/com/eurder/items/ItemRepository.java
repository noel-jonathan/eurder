package com.eurder.items;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.NoSuchElementException;

@ApplicationScoped

public class ItemRepository {
    private final HashMap<String, Item> items = new HashMap<>();

    public HashMap<String, Item> getItems() {
        return items;
    }
    public Item getItem(String id) {
        if (!items.containsKey(id)) {
            throw new NoSuchElementException("No item with id " + id + " found");
        }
        return items.get(id);
    }
    public void add(Item item) {
        items.put(item.getId(), item);
    }
}
