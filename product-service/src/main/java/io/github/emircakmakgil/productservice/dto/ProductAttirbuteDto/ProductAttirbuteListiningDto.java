package io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
public class ProductAttirbuteListiningDto {
    private String productName;
    private String attributeName;
    private String attributeValue;
    private String attributeType;
    private String unit;
    private Integer sortOrder;
    private Boolean isSearchable;
    private Boolean isFilterable;
    private Boolean isVisible;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors
    public ProductAttirbuteListiningDto() {}

    public ProductAttirbuteListiningDto(String productName, String attributeName, String attributeValue,
                                      String attributeType, String unit, Integer sortOrder, Boolean isSearchable, Boolean isFilterable,
                                      Boolean isVisible, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.productName = productName;
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
        this.attributeType = attributeType;
        this.unit = unit;
        this.sortOrder = sortOrder;
        this.isSearchable = isSearchable;
        this.isFilterable = isFilterable;
        this.isVisible = isVisible;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
