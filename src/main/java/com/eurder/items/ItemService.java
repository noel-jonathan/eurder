package com.eurder.items;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDto get(String id) {
        return itemMapper.toDto(itemRepository.get(id));
    }

    public Set<ItemDto> getItems() {
        return itemRepository.getItems().values().stream()
                .map(itemMapper::toDto)
                .collect(Collectors.toSet());
    }

    public ItemDto add(ItemDto itemDto) {
        Item item = itemMapper.toEntity(itemDto);
        itemRepository.add(item);
        return itemMapper.toDto(item);
    }
}
