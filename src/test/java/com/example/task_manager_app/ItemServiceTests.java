package com.example.task_manager_app;

import com.example.task_manager_app.model.Item;
import com.example.task_manager_app.services.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ItemServiceTests {

    @Autowired
    private ItemService itemService;

    @Test
    void contextLoads() {
        assertNotNull(itemService);
    }

    @Test
    void testCreateAndFindItem() {
        Item item = new Item();
        item.setName("Test Item");
        item.setStatus("TODO");
        item.setHighlighted(false);

        Item createdItem = itemService.createItem(item);

        assertNotNull(createdItem.getId());
        assertEquals("Test Item", createdItem.getName());

        Optional<Item> foundItem = itemService.getItemById(createdItem.getId());
        assertTrue(foundItem.isPresent());
        assertEquals("Test Item", foundItem.get().getName());
    }

    @Test
    void testUpdateItem() {
        Item item = new Item();
        item.setName("Old Item");
        item.setStatus("TODO");
        item.setHighlighted(false);

        Item createdItem = itemService.createItem(item);

        createdItem.setName("Updated Item");
        Item updatedItem = itemService.updateItem(createdItem);

        assertEquals("Updated Item", updatedItem.getName());
    }

    @Test
    void testDeleteItem() {
        Item item = new Item();
        item.setName("Item to Delete");
        item.setStatus("TODO");
        item.setHighlighted(false);

        Item createdItem = itemService.createItem(item);

        boolean deleted = itemService.deleteItem(createdItem.getId());
        assertTrue(deleted);

        Optional<Item> foundItem = itemService.getItemById(createdItem.getId());
        assertFalse(foundItem.isPresent());
    }
}