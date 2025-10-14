package io.github.emircakmakgil.productservice.controller;

import io.github.emircakmakgil.productservice.dto.ProductDto.CreateProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.DeleteProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.ProductListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.UpdateProductDto;
import io.github.emircakmakgil.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(code= HttpStatus.OK)
    public List<ProductListiningDto> getAll(){
        return this.productService.getAll();
    }
    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void createProduct(@RequestBody CreateProductDto createProductDto){
        this.productService.add(createProductDto);
    }

    @PutMapping
    @ResponseStatus(code= HttpStatus.OK)
    public void updateProduct(@RequestBody UpdateProductDto updateProductDto){
        this.productService.update(updateProductDto);
    }
    @DeleteMapping
    @ResponseStatus(code= HttpStatus.OK)
    public void deleteProduct(@RequestBody DeleteProductDto deleteProductDto){
        this.productService.delete(deleteProductDto);
    }
    @GetMapping("/ACTIVE")
    @ResponseStatus(code= HttpStatus.OK)
    public List<ProductListiningDto> getActiveProducts(){
        return this.productService.getActiveProducts();
    }
    @GetMapping("INACTIVE")
    @ResponseStatus(code= HttpStatus.OK)
    public List<ProductListiningDto> getInActiveProducts(){
        return this.productService.getInActiveProducts();
    }

}
