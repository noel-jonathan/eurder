package com.eurder.items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ItemServiceTest {
    public static final Item ITEM = new Item(
            "name",
            "description",
            19.99,
            5
    );
    public static final ItemDto ITEM_DTO = new ItemDto(
            ITEM.getId(),
            "name",
            "description",
            19.99,
            5
    );
    @Mock
    private ItemRepository itemRepository;
    @Mock
    private ItemMapper itemMapper;
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        itemService = new ItemService(itemRepository, itemMapper);
    }

    @Test
    void add() {
        when(itemMapper.toEntity(ITEM_DTO)).thenReturn(ITEM);
        itemService.add(ITEM_DTO);

        verify(itemRepository).add(ITEM);
        verify(itemMapper).toEntity(ITEM_DTO);
        verify(itemMapper).toDto(ITEM);
    }

    @Test
    void getItems() {
        HashMap<String, Item> expected = new HashMap<>();
        expected.put(ITEM.getId(), ITEM);
        when(itemRepository.getItems()).thenReturn(expected);


        HashMap<String, ItemDto> actualItems = itemService.getItems();

        verify(itemRepository).getItems();
        assertEquals(expected.size(), actualItems.size());
    }

}