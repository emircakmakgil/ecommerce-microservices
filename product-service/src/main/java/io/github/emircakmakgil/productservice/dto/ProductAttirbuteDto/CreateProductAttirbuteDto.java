package io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateProductAttirbuteDto {
    private UUID productId;
    private String attributeName;
    private String attributeValue;
    private String attributeType;
    private String unit;
    private Integer sortOrder;
    private Boolean isSearchable;
    private Boolean isFilterable;
    private Boolean isVisible;
}
