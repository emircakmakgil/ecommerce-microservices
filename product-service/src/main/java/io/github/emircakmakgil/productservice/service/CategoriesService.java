package io.github.emircakmakgil.productservice.service;


import io.github.emircakmakgil.productservice.dto.CategoriesDto.CreateCategoriesDto;
import io.github.emircakmakgil.productservice.entity.Categories;

import java.util.List;
import java.util.UUID;

public interface CategoriesService {
    void add(CreateCategoriesDto createCategoriesDto);
    List<Categories> getAll() throws InterruptedException;
    Categories update(UUID id,Categories updateCategoryDto);
    void delete(UUID id, Categories deleteCategoryDto);
    void clearCache();
}
