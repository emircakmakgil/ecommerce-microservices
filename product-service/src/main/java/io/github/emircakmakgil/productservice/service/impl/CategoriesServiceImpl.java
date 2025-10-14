package io.github.emircakmakgil.productservice.service.impl;

import io.github.emircakmakgil.productservice.core.exception.type.BusinessException;
import io.github.emircakmakgil.productservice.dto.CategoriesDto.CreateCategoriesDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.CreateCategoryDto;
import io.github.emircakmakgil.productservice.entity.Categories;
import io.github.emircakmakgil.productservice.repository.CategoriesRepository;
import io.github.emircakmakgil.productservice.service.CategoriesService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import static io.github.emircakmakgil.productservice.constant.GeneralConstant.CATEGORY_NOT_FOUND;
@Service
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }


    @Override
    public void add(CreateCategoriesDto createCategoriesDto) {
        Categories categories=new Categories();
        categories.setName(createCategoriesDto.getName());
        categories.setDescription(createCategoriesDto.getDescription());
        categoriesRepository.save(categories);
    }

    @Override
    @Cacheable(cacheNames = "categories")
    public List<Categories> getAll() throws InterruptedException {
        Thread.sleep(5000L);
        return (List<Categories>) categoriesRepository.findAll();
    }
    @CacheEvict(cacheNames = "categories")
    public void clearCache(){
        System.out.println("Cache cleared");
    }

    @Override
    public Categories update(UUID id, Categories updateCategoryDto) {
        Categories category=categoriesRepository.findById(id).orElseThrow(()->new BusinessException(CATEGORY_NOT_FOUND+id));
        return categoriesRepository.save(category);
    }


    @Override
    public void delete(UUID id, Categories deleteCategoryDto) {
        Categories category=categoriesRepository.findById(id).orElseThrow(()->new BusinessException(CATEGORY_NOT_FOUND+id));
        categoriesRepository.delete(category);

    }
}
