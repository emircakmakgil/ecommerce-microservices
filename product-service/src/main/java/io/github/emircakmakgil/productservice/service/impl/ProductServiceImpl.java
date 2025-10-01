package io.github.emircakmakgil.productservice.service.impl;

import io.github.emircakmakgil.productservice.dto.ProductDto.CreateProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.DeleteProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.ProductListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.UpdateProductDto;
import io.github.emircakmakgil.productservice.entity.Product;
import io.github.emircakmakgil.productservice.mapper.ProductMapper;
import io.github.emircakmakgil.productservice.repository.ProductRepository;
import io.github.emircakmakgil.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.github.emircakmakgil.productservice.constant.GeneralConstant.PRODUCT_NOT_FOUND;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> findAll(List<UUID> product) {
        List<Product> products = productRepository.findAllById(product);
        return products;
    }

    @Override
    public Product findById(UUID id) {
        Product product= productRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException(PRODUCT_NOT_FOUND + id));

        return product;
    }

    @Override
    public void add(CreateProductDto createProductDto) {
        Product product=productMapper.createProductFromCreateProductDto(createProductDto);
        productRepository.save(product);
    }

    @Override
    public List<ProductListiningDto> getAll() {
        List<Product> products=productRepository.findAll();
        List<ProductListiningDto> productListiningDtos=products
                .stream()
                .map(productMapper::toProductListiningDto)
                .collect(Collectors.toList());
        return productListiningDtos;
    }

    @Override
    public Product update(UpdateProductDto updateProductDto) {
        Product product=productRepository.findById(updateProductDto.getId()).orElseThrow(()->new RuntimeException(PRODUCT_NOT_FOUND+updateProductDto.getId()));
        productMapper.updateProductFromUpdatedProductDto(updateProductDto,product);
        return productRepository.save(product);
    }

    @Override
    public void delete(DeleteProductDto deleteProductDto) {
        Product product = productRepository.findById(deleteProductDto.getId()).orElseThrow(() -> new RuntimeException(PRODUCT_NOT_FOUND + deleteProductDto.getId()));
        productRepository.delete(product);

    }
}
