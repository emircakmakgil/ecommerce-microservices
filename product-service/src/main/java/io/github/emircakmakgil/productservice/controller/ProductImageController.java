package io.github.emircakmakgil.productservice.controller;

import io.github.emircakmakgil.productservice.dto.ProductDto.DeleteProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.UpdateProductDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.CreateProductImageDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.DeleteProductImageDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.ProductImageListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.UpdateProductImageDto;
import io.github.emircakmakgil.productservice.service.ProductImageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-images")
public class ProductImageController {
    private final ProductImageService productImageService;
    public ProductImageController(ProductImageService productImageService) {
        this.productImageService = productImageService;
    }
    @GetMapping
    @ResponseStatus(code= HttpStatus.OK)
    public List<ProductImageListiningDto> getProductImages() {
        return this.productImageService.getAll();
    }
    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void addProductImage(@RequestBody CreateProductImageDto createProductImageDto){
        this.productImageService.add(createProductImageDto);
    }
    @PutMapping
    @ResponseStatus(code= HttpStatus.OK)
    public void update(@RequestBody UpdateProductImageDto updateProductImageDto){
        this.productImageService.update(updateProductImageDto);
    }
    @DeleteMapping
    @ResponseStatus(code= HttpStatus.OK)
    public void delete(@RequestBody DeleteProductImageDto deleteProductImageDto){
        this.productImageService.delete(deleteProductImageDto);
    }

}
