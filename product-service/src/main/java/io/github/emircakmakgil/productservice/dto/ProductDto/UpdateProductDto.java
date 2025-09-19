package io.github.emircakmakgil.productservice.dto.ProductDto;

import io.github.emircakmakgil.productservice.model.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
public class UpdateProductDto {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private Double weight;
    private ProductType productType;


    public UpdateProductDto( String name, String description, BigDecimal price, Integer stockQuantity,
                            Double weight,ProductType productType) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.weight = weight;
        this.productType = productType;
    }

}
