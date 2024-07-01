package com.example.test.items;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemRestController {
    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemEntity> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping("/create")
    public ResponseEntity<ItemEntity> addItem(@Valid @RequestBody CreateItemDto itemDto) {
        ItemEntity savedItem = itemService.createItem(itemDto);
        return ResponseEntity.ok(savedItem);
    }
}