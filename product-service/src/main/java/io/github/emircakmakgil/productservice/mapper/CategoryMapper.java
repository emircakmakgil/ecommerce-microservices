package io.github.emircakmakgil.productservice.mapper;

import io.github.emircakmakgil.productservice.dto.BrandDto.UpdateBrandDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.CategoryListiningDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.CreateCategoryDto;
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
    public Category updateCategoryFromUpdateCategoryDto(UpdateBrandDto updateBrandDto){
         return Category.builder()
                 .name(updateBrandDto.getName())
                 .description(updateBrandDto.getDescription())
                 .imageUrl(updateBrandDto.getLogoUrl())
                 .status(updateBrandDto.getStatus())
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
