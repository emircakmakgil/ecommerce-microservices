package io.github.emircakmakgil.orderservice.dto.ItemDto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CreateItemDto {
    private UUID productId;
    private String productName;
    private BigDecimal unitPrice;
    private Integer quantity;



}
