package io.github.emircakmakgil.orderservice.dto.ItemDto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ItemListiningDto {
    private String productName;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal subTotal;
    public ItemListiningDto(String productName, BigDecimal unitPrice, Integer quantity, BigDecimal subTotal) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }
}
