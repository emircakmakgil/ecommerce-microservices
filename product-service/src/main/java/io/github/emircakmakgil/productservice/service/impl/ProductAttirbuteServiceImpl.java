package io.github.emircakmakgil.productservice.service.impl;

import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.CreateProductAttirbuteDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.DeleteProductAttirbuteDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.ProductAttirbuteListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.UpdateProductAttirbuteDto;

import io.github.emircakmakgil.productservice.entity.ProductAttribute;
import io.github.emircakmakgil.productservice.mapper.ProductAttirbuteMapper;
import io.github.emircakmakgil.productservice.repository.ProductAttributeRepository;
import io.github.emircakmakgil.productservice.service.ProductAttirbuteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductAttirbuteServiceImpl implements ProductAttirbuteService {
    private final ProductAttributeRepository productAttributeRepository;
    private final ProductAttirbuteMapper productAttirbuteMapper;

    public ProductAttirbuteServiceImpl(ProductAttributeRepository productAttributeRepository, ProductAttirbuteMapper productAttirbuteMapper) {
        this.productAttributeRepository = productAttributeRepository;
        this.productAttirbuteMapper = productAttirbuteMapper;
    }


    @Override
    public List<ProductAttribute> findAll(List<UUID> productAttribute) {
        List<ProductAttribute> productAttributes = productAttributeRepository.findAllById(productAttribute);
        return productAttributes;
    }

    @Override
    public ProductAttribute findById(UUID id) {
            ProductAttribute productAttribute=productAttributeRepository.findById(id).orElseThrow(()->new RuntimeException("Product Attribute not found with id: "+id));
        return productAttribute;
    }

    @Override
    public void add(CreateProductAttirbuteDto createProductAttirbuteDto) {
        ProductAttribute productAttribute=productAttirbuteMapper.createProductAttributeFromCreateProductAttributeDto(createProductAttirbuteDto);
        productAttributeRepository.save(productAttribute);
    }

    @Override
    public List<ProductAttirbuteListiningDto> getAll() {
        List<ProductAttribute> productAttributes=productAttributeRepository.findAll();
        List<ProductAttirbuteListiningDto> productAttirbuteListiningDtos=productAttributes
                .stream()
                .map(productAttirbuteMapper::toProductAttributeListiningDto)
                .collect(Collectors.toList());
        return productAttirbuteListiningDtos;
    }

    @Override
    public ProductAttribute update(UpdateProductAttirbuteDto dto) {
        ProductAttribute entity = productAttributeRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Product Attribute not found with id: " + dto.getId()));

        productAttirbuteMapper.updateProductAttributeFromUpdateProductAttributeDto(dto, entity);

        return productAttributeRepository.save(entity);
    }

    @Override
    public void delete(DeleteProductAttirbuteDto deleteProductAttirbuteDto) {
        ProductAttribute productAttribute=productAttributeRepository
                .findById(deleteProductAttirbuteDto.getId())
                .orElseThrow(()->new RuntimeException("Product Attribute not found with id: "+deleteProductAttirbuteDto.getId()));
        productAttributeRepository.delete(productAttribute);

    }
}
