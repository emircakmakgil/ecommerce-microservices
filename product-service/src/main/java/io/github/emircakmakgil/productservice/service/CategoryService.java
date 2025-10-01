package io.github.emircakmakgil.productservice.service;



import io.github.emircakmakgil.productservice.dto.CategoryDto.CategoryListiningDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.CreateCategoryDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.DeleteCategoryDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.UpdateCategoryDto;
import io.github.emircakmakgil.productservice.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> findAll(List<UUID> category);
    Category findById(UUID id);
    void add(CreateCategoryDto createCategoryDto);
    List<CategoryListiningDto> getAll();
    Category update(UpdateCategoryDto updateCategoryDto);
    void delete(DeleteCategoryDto deleteCategoryDto);
}
