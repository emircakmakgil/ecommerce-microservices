package io.github.emircakmakgil.productservice.service;

import io.github.emircakmakgil.productservice.dto.ProductImageDto.CreateProductImageDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.DeleteProductImageDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.ProductImageListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.UpdateProductImageDto;
import io.github.emircakmakgil.productservice.entity.ProductImage;
import java.util.List;
import java.util.UUID;

public interface ProductImageService  {
    List<ProductImage> findAll(List<UUID> productImage);
    ProductImage findById(UUID id);
    void add(CreateProductImageDto createProductImageDto);
    List<ProductImageListiningDto> getAll();
    ProductImage update(UpdateProductImageDto updateProductImageDto);
    void delete(DeleteProductImageDto deleteProductImageDto);
}
