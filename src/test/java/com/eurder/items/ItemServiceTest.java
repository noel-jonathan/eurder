package com.eurder.items;

import com.eurder.TestConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ItemServiceTest {
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
        when(itemMapper.toEntity(TestConstants.ITEM_DTO)).thenReturn(TestConstants.ITEM);
        itemService.add(TestConstants.ITEM_DTO);

        verify(itemRepository).add(TestConstants.ITEM);
        verify(itemMapper).toEntity(TestConstants.ITEM_DTO);
        verify(itemMapper).toDto(TestConstants.ITEM);
    }

    @Test
    void getItems() {
        HashMap<String, Item> expected = new HashMap<>();
        expected.put(TestConstants.ITEM.getId(), TestConstants.ITEM);
        when(itemRepository.getItems()).thenReturn(expected);


        HashMap<String, ItemDto> actualItems = itemService.getItems();

        verify(itemRepository).getItems();
        assertEquals(expected.size(), actualItems.size());
    }

}