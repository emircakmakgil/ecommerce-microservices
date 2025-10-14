package io.github.emircakmakgil.productservice.service.impl;

import io.github.emircakmakgil.productservice.core.exception.type.BusinessException;
import io.github.emircakmakgil.productservice.dto.CategoryDto.CategoryListiningDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.CreateCategoryDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.DeleteCategoryDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.UpdateCategoryDto;
import io.github.emircakmakgil.productservice.entity.Category;
import io.github.emircakmakgil.productservice.mapper.CategoryMapper;
import io.github.emircakmakgil.productservice.repository.CategoryRepository;
import io.github.emircakmakgil.productservice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.github.emircakmakgil.productservice.constant.GeneralConstant.CATEGORY_NOT_FOUND;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> findAll(List<UUID> category) {
        List<Category> categories = categoryRepository.findAllById(category);
      //TODO: Add logging
        return categories;
    }

    @Override
    public Category findById(UUID id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->new BusinessException(CATEGORY_NOT_FOUND+id));
        //TODO: Add logging
        return category;
    }

    @Override
    public void add(CreateCategoryDto createCategoryDto) {
        Category category=categoryMapper.createCategoryFromCreateCategoryDto(createCategoryDto);
        category.setCreatedAt(LocalDateTime.now());
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryListiningDto> getAll() {
        List<Category> category=categoryRepository.findAll();
        List<CategoryListiningDto> categoryListiningDtos=category
                .stream()
                .map(categoryMapper::toCategoryListiningDto)
                .collect(Collectors.toList());
        return categoryListiningDtos;
    }

    @Override
    public Category update(UpdateCategoryDto updateCategoryDto) {
        Category category=categoryRepository.findById(updateCategoryDto.getId()).orElseThrow(()->new BusinessException(CATEGORY_NOT_FOUND+updateCategoryDto.getId()));
        categoryMapper.updateCategoryFromUpdateCategoryDto(updateCategoryDto,category);
        return categoryRepository.save(category);
    }

    @Override
    public void delete(DeleteCategoryDto deleteCategoryDto) {
        Category category=categoryRepository.findById(deleteCategoryDto.getId()).orElseThrow(()->new BusinessException(CATEGORY_NOT_FOUND+deleteCategoryDto.getId()));
        categoryRepository.delete(category);

    }

  @Override
  public CategoryListiningDto findByName(String name) {
      Category category = categoryRepository.findByName(name);
        if (category == null) {
            throw new BusinessException(CATEGORY_NOT_FOUND + name);
        }
      return categoryMapper.toCategoryListiningDto(category);
  }
}
