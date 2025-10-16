package io.github.emircakmakgil.orderservice.services.impl;

import io.github.emircakmakgil.orderservice.constant.GeneralConstrant;
import io.github.emircakmakgil.orderservice.dto.ItemDto.CreateItemDto;
import io.github.emircakmakgil.orderservice.dto.ItemDto.DeleteItemDto;
import io.github.emircakmakgil.orderservice.dto.ItemDto.ItemListiningDto;
import io.github.emircakmakgil.orderservice.dto.ItemDto.UpdateItemDto;
import io.github.emircakmakgil.orderservice.entity.Item;
import io.github.emircakmakgil.orderservice.mapper.ItemMapper;
import io.github.emircakmakgil.orderservice.repository.ItemRepository;
import io.github.emircakmakgil.orderservice.services.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.github.emircakmakgil.orderservice.constant.GeneralConstrant.ITEM_NOT_FOUND;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }
    @Override
    public List<Item> findAll(List<UUID> item) {
        return  itemRepository.findAllById(item);
    }

    @Override
    public Item findById(UUID id) {
        return itemRepository.findById(id).orElseThrow(()->new RuntimeException(ITEM_NOT_FOUND +id));
    }

    //TODO:SUBTOTAL CALCULATION
    @Override
    public void add(CreateItemDto createItemDto) {
        Item item=itemMapper.createItemFromCreateItemDto(createItemDto);
        itemRepository.save(item);

    }

    @Override
    public List<ItemListiningDto> getAll() {
        List<Item> items=itemRepository.findAll();
        List<ItemListiningDto> itemListiningDtos=items
                .stream()
                .map(itemMapper::toItemListiningDto)
                .collect(Collectors.toList());
        return itemListiningDtos;
    }

    @Override
    public Item update(UpdateItemDto updateItemDto) {
        Item item=itemRepository.findById(updateItemDto.getId()).orElseThrow(()->new RuntimeException(ITEM_NOT_FOUND+updateItemDto.getId()));
        itemMapper.updateItemFromCreateItemDto(updateItemDto,item);
        return itemRepository.save(item);
    }

    @Override
    public void delete(DeleteItemDto deleteItemDto) {
        Item item=itemRepository.findById(deleteItemDto.getId()).orElseThrow(()->new RuntimeException(ITEM_NOT_FOUND+deleteItemDto.getId()));
        itemRepository.delete(item);
    }
}
