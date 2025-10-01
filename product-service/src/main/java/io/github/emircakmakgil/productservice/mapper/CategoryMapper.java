package io.github.emircakmakgil.productservice.mapper;

import io.github.emircakmakgil.productservice.dto.CategoryDto.CategoryListiningDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.CreateCategoryDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.UpdateCategoryDto;
import io.github.emircakmakgil.productservice.entity.Category;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CategoryMapper {
    public Category createCategoryFromCreateCategoryDto(CreateCategoryDto createCategoryDto){
        return Category
                .builder()
                .name(createCategoryDto.getName())
                .description(createCategoryDto.getDescription())
                .imageUrl(createCategoryDto.getImageUrl())
                .build();
    }
    public Category updateCategoryFromUpdateCategoryDto(UpdateCategoryDto updateCategoryDto){
         return Category.builder()
                 .name(updateCategoryDto.getName())
                 .description(updateCategoryDto.getDescription())
                 .status(updateCategoryDto.getStatus())
                 .imageUrl(updateCategoryDto.getImageUrl())
                .build();

    }
    public CategoryListiningDto toCategoryListiningDto(Category category){
        return new CategoryListiningDto(
                category.getName(),
                category.getDescription(),
                category.getImageUrl(),
                category.getStatus(),
                category.getCreatedAt(),
                category.getUpdatedAt()
        );

    }
}
