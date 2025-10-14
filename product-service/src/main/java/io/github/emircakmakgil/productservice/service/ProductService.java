package io.github.emircakmakgil.productservice.service;

import io.github.emircakmakgil.productservice.dto.ProductDto.CreateProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.DeleteProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.ProductListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.UpdateProductDto;
import io.github.emircakmakgil.productservice.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> findAll(List<UUID> product);
    Product findById(UUID id);
    void add(CreateProductDto createProductDto);
    List<ProductListiningDto> getAll();
    Product update(UpdateProductDto updateProductDto);
    void delete(DeleteProductDto deleteProductDto);
    List<ProductListiningDto> getActiveProducts();
    List<ProductListiningDto> getInActiveProducts();


}
