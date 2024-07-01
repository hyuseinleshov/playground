package com.example.test.items;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    public ItemEntity createItem(CreateItemDto itemDto) {
        ItemEntity item = new ItemEntity();
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());

        return itemRepository.save(item);
    }
}
