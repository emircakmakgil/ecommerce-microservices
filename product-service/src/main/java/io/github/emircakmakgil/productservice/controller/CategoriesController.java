package io.github.emircakmakgil.productservice.controller;


import io.github.emircakmakgil.productservice.dto.CategoriesDto.CreateCategoriesDto;
import io.github.emircakmakgil.productservice.entity.Categories;
import io.github.emircakmakgil.productservice.service.CategoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
public class CategoriesController {
    private final CategoriesService categoriesService;
    private int sayac=0;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }
    @GetMapping
    @ResponseStatus(code= HttpStatus.OK)
    public List<Categories> getAll() throws InterruptedException {
        if(sayac==5){
            categoriesService.clearCache();
            sayac=0;
        }
        sayac++;
        return this.categoriesService.getAll();
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void createBrand(@RequestBody CreateCategoriesDto categories){
        this.categoriesService.add(categories);
    }

}
