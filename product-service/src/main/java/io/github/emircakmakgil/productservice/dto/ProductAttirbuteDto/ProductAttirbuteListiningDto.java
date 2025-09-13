package io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
public class ProductAttirbuteListiningDto {
    private String attributeName;
    private String attributeValue;
    private String unit;
    private Boolean isSearchable;
    private Boolean isFilterable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductAttirbuteListiningDto() {}

    public ProductAttirbuteListiningDto(String attributeName, String attributeValue,
                                       String unit,Boolean isSearchable, Boolean isFilterable,
                                       LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
        this.unit = unit;
        this.isSearchable = isSearchable;
        this.isFilterable = isFilterable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
