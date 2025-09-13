package io.github.emircakmakgil.productservice.dto.CategoryDto;

import io.github.emircakmakgil.productservice.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateCategoryDto {
    private UUID id;
    private String name;
    private String description;
    private String imageUrl;
    private Status status;


}
