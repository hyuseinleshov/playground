package com.example.test.items;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDto> findAllItems() {
        List<ItemEntity> items = itemRepository.findAll();
        return items.stream()
                .map(item -> new ItemDto(item.getName(), item.getDescription()))
                .toList();
    }

    public ItemEntity createItem(CreateItemDto itemDto) {
        ItemEntity item = new ItemEntity();
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());

        return itemRepository.save(item);
    }
}
