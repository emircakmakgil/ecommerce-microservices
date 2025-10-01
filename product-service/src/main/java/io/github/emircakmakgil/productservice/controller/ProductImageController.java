package io.github.emircakmakgil.productservice.controller;

import io.github.emircakmakgil.productservice.dto.ProductImageDto.ProductImageListiningDto;
import io.github.emircakmakgil.productservice.service.ProductImageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
        return null;
    }

}
