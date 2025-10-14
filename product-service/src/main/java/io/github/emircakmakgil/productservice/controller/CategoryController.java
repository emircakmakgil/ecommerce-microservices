package io.github.emircakmakgil.productservice.controller;

import io.github.emircakmakgil.productservice.dto.CategoryDto.CategoryListiningDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.CreateCategoryDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.DeleteCategoryDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.UpdateCategoryDto;
import io.github.emircakmakgil.productservice.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(code= HttpStatus.OK)
    public List<CategoryListiningDto> getAll(){
        return this.categoryService.getAll();
    }

    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code= HttpStatus.CREATED)
    public void createCategory(@RequestBody CreateCategoryDto createCategoryDto){
        this.categoryService.add(createCategoryDto);
    }
    @PutMapping
    @ResponseStatus(code= HttpStatus.OK)
    public void updateCategory(@RequestBody UpdateCategoryDto updateCategoryDto){
        this.categoryService.update(updateCategoryDto);
    }
    @DeleteMapping
    @ResponseStatus(code= HttpStatus.OK)
    public void deleteCategory(@RequestBody DeleteCategoryDto deleteCategoryDto){
        this.categoryService.delete(deleteCategoryDto);
    }
    @GetMapping("/name")
    @ResponseStatus(code= HttpStatus.OK)
    public CategoryListiningDto getCategoryByName(@RequestParam String name){
        return categoryService.findByName(name);
    }
    
}
