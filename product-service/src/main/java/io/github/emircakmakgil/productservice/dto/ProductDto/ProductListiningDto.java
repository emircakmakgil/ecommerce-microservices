package io.github.emircakmakgil.productservice.dto.ProductDto;

import io.github.emircakmakgil.productservice.entity.Brand;
import io.github.emircakmakgil.productservice.entity.Category;
import io.github.emircakmakgil.productservice.entity.ProductImage;
import io.github.emircakmakgil.productservice.model.enums.ProductType;
import io.github.emircakmakgil.productservice.model.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class ProductListiningDto {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private Double weight;
    private Status status;
    private ProductType productType;




    public ProductListiningDto(String name, String description, BigDecimal price, Integer stockQuantity, Double weight,Status status,ProductType productType) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.weight = weight;
        this.status = status;
        this.productType = productType;
    }
}
