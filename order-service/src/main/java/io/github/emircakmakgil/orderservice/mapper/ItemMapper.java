package io.github.emircakmakgil.orderservice.mapper;

import io.github.emircakmakgil.orderservice.dto.ItemDto.CreateItemDto;
import io.github.emircakmakgil.orderservice.dto.ItemDto.ItemListiningDto;
import io.github.emircakmakgil.orderservice.entity.Item;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ItemMapper {
    public Item createItemFromCreateItemDto(CreateItemDto createItemDto){
        return Item.builder()
                .productId(createItemDto.getProductId())
                .quantity(createItemDto.getQuantity())
                .productName(createItemDto.getProductName())
                .unitPrice(createItemDto.getUnitPrice())
                .build();
    }
    public void updateItemFromCreateItemDto(CreateItemDto createItemDto, Item item) {
        item.setProductId(createItemDto.getProductId());
        item.setQuantity(createItemDto.getQuantity());
        item.setProductName(createItemDto.getProductName());
        item.setUnitPrice(createItemDto.getUnitPrice());
    }
    public ItemListiningDto toItemListiningDto(Item item){
        return new ItemListiningDto(
                item.getProductName(),
                item.getUnitPrice(),
                item.getQuantity(),
                item.getSubTotal());
    }
}
