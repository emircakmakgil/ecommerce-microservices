package io.github.emircakmakgil.orderservice.services;

import io.github.emircakmakgil.orderservice.dto.ItemDto.CreateItemDto;
import io.github.emircakmakgil.orderservice.dto.ItemDto.DeleteItemDto;
import io.github.emircakmakgil.orderservice.dto.ItemDto.ItemListiningDto;
import io.github.emircakmakgil.orderservice.dto.ItemDto.UpdateItemDto;
import io.github.emircakmakgil.orderservice.entity.Item;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    List<Item> findAll(List<UUID> item);
    Item findById(UUID id);
    void add(CreateItemDto createItemDto);
    List<ItemListiningDto> getAll();
    Item update(UpdateItemDto updateItemDto);
    void delete(DeleteItemDto deleteItemDto);
}
