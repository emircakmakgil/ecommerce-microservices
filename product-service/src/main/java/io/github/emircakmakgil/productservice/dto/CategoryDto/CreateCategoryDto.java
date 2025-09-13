package io.github.emircakmakgil.productservice.dto.CategoryDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateCategoryDto {
    private String name;
    private String description;
    private String imageUrl;
    private UUID parentCategoryId;
    private Integer sortOrder;
    private String status;
}