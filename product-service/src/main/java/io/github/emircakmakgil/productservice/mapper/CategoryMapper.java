package io.github.emircakmakgil.productservice.mapper;

import io.github.emircakmakgil.productservice.dto.CategoryDto.CategoryListiningDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.CreateCategoryDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.UpdateCategoryDto;
import io.github.emircakmakgil.productservice.entity.Category;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class CategoryMapper {
    public Category createCategoryFromCreateCategoryDto(CreateCategoryDto createCategoryDto){
        return Category
                .builder()
                .name(createCategoryDto.getName())
                .description(createCategoryDto.getDescription())
                .imageUrl(createCategoryDto.getImageUrl())
                .status(createCategoryDto.getStatus())
                .build();
    }
    public void updateCategoryFromUpdateCategoryDto(UpdateCategoryDto updateCategoryDto, Category category) {
                category.setName(updateCategoryDto.getName());
                category.setDescription(updateCategoryDto.getDescription());
                category.setStatus(updateCategoryDto.getStatus());
                category.setImageUrl(updateCategoryDto.getImageUrl());
                category.setUpdatedAt(LocalDateTime.now());
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
