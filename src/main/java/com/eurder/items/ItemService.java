package com.eurder.items;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDto get(String id) {
        return itemMapper.toDto(itemRepository.getItem(id));
    }

    public HashMap<String, ItemDto> getItems() {
        HashMap<String, ItemDto> resultHashMap = new HashMap<>();

        for (Map.Entry<String, Item> entry : itemRepository.getItems().entrySet()) {
            String key = entry.getKey();
            Item item = entry.getValue();
            ItemDto itemDto = itemMapper.toDto(item); // Use your ItemMapper
            resultHashMap.put(key, itemDto);
        }

        return resultHashMap;
    }

    public ItemDto add(ItemDto itemDto) {
        Item item = itemMapper.toEntity(itemDto);
        itemRepository.add(item);
        return itemMapper.toDto(item);
    }
}
