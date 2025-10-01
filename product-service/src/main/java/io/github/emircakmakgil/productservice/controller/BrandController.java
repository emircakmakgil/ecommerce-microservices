package io.github.emircakmakgil.productservice.controller;

import io.github.emircakmakgil.productservice.dto.BrandDto.BrandListiningDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.CreateBrandDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.DeleteBrandDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.UpdateBrandDto;
import io.github.emircakmakgil.productservice.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    @ResponseStatus(code= HttpStatus.OK)
    public List<BrandListiningDto> getAll(){
        return this.brandService.getAll();
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void createBrand(@RequestBody CreateBrandDto createBrandDto){
        this.brandService.add(createBrandDto);
    }

    @PutMapping
    @ResponseStatus(code= HttpStatus.OK)
    public void updateBrand(@RequestBody UpdateBrandDto updateBrandDto){
        this.brandService.update(updateBrandDto);
    }
    @DeleteMapping
    @ResponseStatus(code= HttpStatus.OK)
    public void deleteBrand(@RequestBody DeleteBrandDto deleteBrandDto){
        this.brandService.delete(deleteBrandDto);
    }

}
