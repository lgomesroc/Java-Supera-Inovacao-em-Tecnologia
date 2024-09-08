package com.example.task_manager_app.controller;

import com.example.task_manager_app.model.Item;
import com.example.task_manager_app.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Endpoint para obter todos os itens
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Endpoint para obter um item pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> item = itemService.getItemById(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para criar um novo item
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um item existente
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Optional<Item> existingItem = itemService.getItemById(id);
        if (existingItem.isPresent()) {
            item.setId(id); // Garantir que o ID está definido para a atualização
            Item updatedItem = itemService.updateItem(item);
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para deletar um item pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (itemService.deleteItem(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para obter todos os itens filtrados por nome
    @GetMapping("/filter")
    public ResponseEntity<List<Item>> getItemsByName(@RequestParam String name) {
        List<Item> items = itemService.getItemsByName(name);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}