package io.github.emircakmakgil.productservice.dto.CategoryDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryListiningDto {
    private String name;
    private String description;
    private String imageUrl;
    private UUID parentCategoryId;
    private String parentCategoryName;
    private Integer sortOrder;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer productCount;
    private List<CategoryListiningDto> subCategories;

    public CategoryListiningDto() {}

    public CategoryListiningDto(String name, String description, String imageUrl, UUID parentCategoryId,
                              String parentCategoryName, Integer sortOrder, String status, LocalDateTime createdAt,
                              LocalDateTime updatedAt, Integer productCount, List<CategoryListiningDto> subCategories) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.parentCategoryId = parentCategoryId;
        this.parentCategoryName = parentCategoryName;
        this.sortOrder = sortOrder;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productCount = productCount;
        this.subCategories = subCategories;
    }
}
