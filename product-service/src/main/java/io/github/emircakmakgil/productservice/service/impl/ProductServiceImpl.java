package io.github.emircakmakgil.productservice.service.impl;

import io.github.emircakmakgil.productservice.core.exception.type.BusinessException;
import io.github.emircakmakgil.productservice.dto.ProductDto.CreateProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.DeleteProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.ProductListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.UpdateProductDto;
import io.github.emircakmakgil.productservice.entity.Brand;
import io.github.emircakmakgil.productservice.entity.Category;
import io.github.emircakmakgil.productservice.entity.Product;
import io.github.emircakmakgil.productservice.mapper.ProductMapper;
import io.github.emircakmakgil.productservice.model.enums.Status;
import io.github.emircakmakgil.productservice.repository.ProductRepository;
import io.github.emircakmakgil.productservice.service.BrandService;
import io.github.emircakmakgil.productservice.service.CategoryService;
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
    private final BrandService brandService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, BrandService brandService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }

    @Override
    public List<Product> findAll(List<UUID> product) {
        List<Product> products = productRepository.findAllById(product);
        return products;
    }

    @Override
    public Product findById(UUID id) {
        return productRepository.findById(id).orElseThrow(()->new BusinessException(PRODUCT_NOT_FOUND+id));
    }

    @Override
    public void add(CreateProductDto createProductDto) {
        Brand brand=brandService.findById(createProductDto.getBrandId());
        Category category=categoryService.findById(createProductDto.getCategoryId());
        Product product=productMapper.createProductFromCreateProductDto(createProductDto);
        product.setBrand(brand);
        product.setCategory(category);
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
        Brand brand=brandService.findById(updateProductDto.getBrandId());
        Category category=categoryService.findById(updateProductDto.getCategoryId());

        Product product=productRepository.findById(updateProductDto.getId()).orElseThrow(()->new BusinessException(PRODUCT_NOT_FOUND+updateProductDto.getId()));
        product.setBrand(brand);
        product.setCategory(category);
        productMapper.updateProductFromUpdatedProductDto(updateProductDto,product);
        return productRepository.save(product);
    }

    @Override
    public void delete(DeleteProductDto deleteProductDto) {
        Product product = productRepository.findById(deleteProductDto.getId()).orElseThrow(() -> new BusinessException(PRODUCT_NOT_FOUND + deleteProductDto.getId()));
        productRepository.delete(product);
    }

    @Override
    public List<ProductListiningDto> getActiveProducts() {
        List<Product> products=productRepository.findAll();
        List<ProductListiningDto> productListiningDtos=products
                .stream()
                .filter(product -> Status.ACTIVE.equals(product.getStatus().toString()))
                .map(productMapper::toProductListiningDto)
                .collect(Collectors.toList());
        return productListiningDtos;
    }

    @Override
    public List<ProductListiningDto> getInActiveProducts() {
        List<Product> products=productRepository.findAll();
        List<ProductListiningDto> productListiningDtos=products
                .stream()
                .filter(product -> Status.INACTIVE.equals(product.getStatus().toString()))
                .map(productMapper::toProductListiningDto)
                .collect(Collectors.toList());
        return productListiningDtos;
    }

}
