package io.github.emircakmakgil.productservice.service.impl;

import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.CreateProductAttirbuteDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.DeleteProductAttirbuteDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.ProductAttirbuteListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.UpdateProductAttirbuteDto;

import io.github.emircakmakgil.productservice.entity.Product;
import io.github.emircakmakgil.productservice.entity.ProductAttribute;
import io.github.emircakmakgil.productservice.mapper.ProductAttirbuteMapper;
import io.github.emircakmakgil.productservice.repository.ProductAttributeRepository;
import io.github.emircakmakgil.productservice.service.ProductAttirbuteService;
import io.github.emircakmakgil.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.github.emircakmakgil.productservice.constant.GeneralConstant.PRODUCT_ATTRIBUTE_NOT_FOUND;

@Service
public class ProductAttirbuteServiceImpl implements ProductAttirbuteService {
    private final ProductAttributeRepository productAttributeRepository;
    private final ProductAttirbuteMapper productAttirbuteMapper;
    private final ProductService productService;
    public ProductAttirbuteServiceImpl(ProductAttributeRepository productAttributeRepository, ProductAttirbuteMapper productAttirbuteMapper, ProductService productService) {
        this.productAttributeRepository = productAttributeRepository;
        this.productAttirbuteMapper = productAttirbuteMapper;
        this.productService = productService;
    }


    @Override
    public List<ProductAttribute> findAll(List<UUID> productAttribute) {
        List<ProductAttribute> productAttributes = productAttributeRepository.findAllById(productAttribute);
        return productAttributes;
    }

    @Override
    public ProductAttribute findById(UUID id) {
            ProductAttribute productAttribute=productAttributeRepository.findById(id).orElseThrow(()->new RuntimeException(PRODUCT_ATTRIBUTE_NOT_FOUND+id));
        return productAttribute;
    }

    @Override
    public void add(CreateProductAttirbuteDto createProductAttirbuteDto) {
        Product product=productService.findById(createProductAttirbuteDto.getProductId()).orElseThrow(()-> new RuntimeException("Product Not Found"));
        ProductAttribute productAttribute=productAttirbuteMapper.createProductAttributeFromCreateProductAttributeDto(createProductAttirbuteDto);
        productAttribute.setProduct(product);
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
                .orElseThrow(() -> new RuntimeException(PRODUCT_ATTRIBUTE_NOT_FOUND+ dto.getId()));

        productAttirbuteMapper.updateProductAttributeFromUpdateProductAttributeDto(dto, entity);

        return productAttributeRepository.save(entity);
    }

    @Override
    public void delete(DeleteProductAttirbuteDto deleteProductAttirbuteDto) {
        ProductAttribute productAttribute=productAttributeRepository
                .findById(deleteProductAttirbuteDto.getId())
                .orElseThrow(()->new RuntimeException(PRODUCT_ATTRIBUTE_NOT_FOUND+deleteProductAttirbuteDto.getId()));
        productAttributeRepository.delete(productAttribute);

    }
}
