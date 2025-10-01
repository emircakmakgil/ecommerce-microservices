package io.github.emircakmakgil.productservice.service;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.CreateProductAttirbuteDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.DeleteProductAttirbuteDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.ProductAttirbuteListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.UpdateProductAttirbuteDto;
import io.github.emircakmakgil.productservice.entity.ProductAttribute;

import java.util.List;
import java.util.UUID;

public interface ProductAttirbuteService {

    List<ProductAttribute> findAll(List<UUID> productAttribute);
    ProductAttribute findById(UUID id);
    void add(CreateProductAttirbuteDto createProductAttirbuteDto);
    List<ProductAttirbuteListiningDto> getAll();
    ProductAttribute update(UpdateProductAttirbuteDto updateProductAttirbuteDto);
    void delete(DeleteProductAttirbuteDto deleteProductAttirbuteDto);
}
