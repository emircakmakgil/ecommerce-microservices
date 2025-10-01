package io.github.emircakmakgil.productservice.controller;

import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.CreateProductAttirbuteDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.DeleteProductAttirbuteDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.ProductAttirbuteListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.UpdateProductAttirbuteDto;
import io.github.emircakmakgil.productservice.service.ProductAttirbuteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-attributes")
public class ProductAttirbuteController {
    private final ProductAttirbuteService productAttirbuteService;

    public ProductAttirbuteController(ProductAttirbuteService productAttirbuteService) {
        this.productAttirbuteService = productAttirbuteService;
    }

    @GetMapping
    @ResponseStatus(code= HttpStatus.OK)
    public List<ProductAttirbuteListiningDto> getAll(){
        return this.productAttirbuteService.getAll();
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void createProductAttirbute(@RequestBody CreateProductAttirbuteDto createProductAttirbuteDto){
        this.productAttirbuteService.add(createProductAttirbuteDto);
    }
    @PutMapping
    @ResponseStatus(code= HttpStatus.OK)
    public void updateProductAttirbute(@RequestBody UpdateProductAttirbuteDto updateProductAttirbuteDto){
        this.productAttirbuteService.update(updateProductAttirbuteDto);
    }
    @DeleteMapping
    @ResponseStatus(code= HttpStatus.OK)
    public void deleteProductAttirbute(@RequestBody DeleteProductAttirbuteDto deleteProductAttirbuteDto){
        this.productAttirbuteService.delete(deleteProductAttirbuteDto);
    }


}
