package io.github.emircakmakgil.productservice.service.impl;

import io.github.emircakmakgil.productservice.dto.ProductImageDto.CreateProductImageDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.DeleteProductImageDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.ProductImageListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.UpdateProductImageDto;
import io.github.emircakmakgil.productservice.entity.ProductImage;
import io.github.emircakmakgil.productservice.mapper.ProductImageMapper;
import io.github.emircakmakgil.productservice.repository.ProductImageRepository;
import io.github.emircakmakgil.productservice.service.ProductImageService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    private final ProductImageRepository productImageRepository;
    private final ProductImageMapper productImageMapper;

    public ProductImageServiceImpl(ProductImageRepository productImageRepository, ProductImageMapper productImageMapper) {
        this.productImageRepository = productImageRepository;
        this.productImageMapper = productImageMapper;
    }

    @Override
    public List<ProductImage> findAll(List<UUID> productImage) {
        List<ProductImage> productImages = productImageRepository.findAllById(productImage);
        return productImages;
    }

    @Override
    public ProductImage findById(UUID id) {
        ProductImage productImage=productImageRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Product Image not found with id: "+id));
        return productImage;
    }

    @Override
    public void add(CreateProductImageDto createProductImageDto) {
        ProductImage productImage=productImageMapper.createProductImageFromCreateProductImage(createProductImageDto);
        productImageRepository.save(productImage);
    }

    @Override
    public List<ProductImageListiningDto> getAll() {
        List<ProductImage> productImages=productImageRepository.findAll();
        List<ProductImageListiningDto> productImageListiningDtos=productImages
                .stream()
                .map(productImageMapper::toProductImageListiningDto)
                .collect(Collectors.toList());
        return productImageListiningDtos;
    }

    @Override
    public ProductImage update(UpdateProductImageDto updateProductImageDto) {
        ProductImage productImage=productImageRepository.findById(updateProductImageDto.getId()).orElseThrow(()->new RuntimeException("Product Image not found with id: "+updateProductImageDto.getId()));
        productImageMapper.updateProductImageFromUpdatedProductImage(updateProductImageDto,productImage);
        return productImageRepository.save(productImage);
    }

    @Override
    public void delete(DeleteProductImageDto deleteProductImageDto) {
        ProductImage productImage=productImageRepository
                .findById(deleteProductImageDto.getId())
                .orElseThrow(()->new RuntimeException("Product Image not found with id: "+deleteProductImageDto.getId()));
        productImageRepository.delete(productImage);
    }
}
