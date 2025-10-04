package io.github.emircakmakgil.productservice.service;

import io.github.emircakmakgil.productservice.dto.ProductDto.CreateProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.DeleteProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.UpdateProductDto;
import io.github.emircakmakgil.productservice.entity.Brand;
import io.github.emircakmakgil.productservice.entity.Category;
import io.github.emircakmakgil.productservice.entity.Product;
import io.github.emircakmakgil.productservice.mapper.ProductMapper;
import io.github.emircakmakgil.productservice.model.enums.Status;
import io.github.emircakmakgil.productservice.repository.ProductRepository;
import io.github.emircakmakgil.productservice.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import java.math.BigDecimal;
import java.util.UUID;


@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    @Mock
    private CategoryService categoryService;
    @Mock
    private BrandService brandService;
    @Mock
    private ProductMapper productMapper;
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    private UUID id;
    private CreateProductDto createProductDto;
    private UpdateProductDto updateProductDto;
    private DeleteProductDto deleteProductDto;
    private Product product;
    private Brand brand;
    private Category category;
    private UUID brandId;
    private UUID categoryId;

    @BeforeEach
    void setup(){
        id=UUID.randomUUID();
        brandId=UUID.randomUUID();
        categoryId=UUID.randomUUID();
        product=new Product();
        product.setId(id);
        product.setName("Test Product");
        product.setDescription("This is a test product");
        product.setPrice(BigDecimal.valueOf(99.99));
        product.setStockQuantity(100);
        product.setWeight(1.5);


        createProductDto=new CreateProductDto();
        createProductDto.setName("Test Product");
        createProductDto.setDescription("This is a test product");
        createProductDto.setPrice(BigDecimal.valueOf(99.99));
        createProductDto.setStockQuantity(100);
        createProductDto.setWeight(1.5);
        createProductDto.setBrandId(brandId);
        createProductDto.setCategoryId(categoryId);


        updateProductDto=new UpdateProductDto();
        updateProductDto.setId(id);
        updateProductDto.setName("Updated Test Product");
        updateProductDto.setDescription("This is an updated test product");
        updateProductDto.setStockQuantity(150);
        updateProductDto.setBrandId(brandId);
        updateProductDto.setCategoryId(categoryId);

        deleteProductDto=new  DeleteProductDto();
        deleteProductDto.setId(id);

        brand=new Brand();
        brand.setId(brandId);
        brand.setName("Test Brand");
        brand.setDescription("This is a test brand");
        brand.setLogoUrl("https://example.com/logo.png");
        brand.setWebsiteUrl("https://example.com");
        brand.setCountryOfOrigin("USA");
        brand.setFoundedYear(1990);

        category=new Category();
        category.setId(categoryId);
        category.setName("Test Category");
        category.setDescription("This is a test category");
        category.setStatus(Status.ACTIVE);
        category.setImageUrl("https://example.com/image.png");
    }
    @Test
    void whenAddCalledWithValidRequest_itShouldSaveProductToRepository(){
        when(categoryService.findById(categoryId)).thenReturn(category);
        when(brandService.findById(brandId)).thenReturn(brand);
        when(productMapper.createProductFromCreateProductDto(createProductDto)).thenReturn(product);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        // Act: Calling the add method
        productServiceImpl.add(createProductDto);

        // Assert: Verifying the interactions

        verify(brandService, times(1)).findById(brandId);
        verify(categoryService, times(1)).findById(categoryId);
        verify(productRepository, times(1)).save(any(Product.class));
        verify(productMapper, times(1)).createProductFromCreateProductDto(createProductDto);
    }
    @Test
    void whenUpdateCalledWithValidRequest_itShouldUpdateProductInRepository(){
        when(categoryService.findById(categoryId)).thenReturn(category);
        when(brandService.findById(brandId)).thenReturn(brand);
        when(productRepository.findById(id)).thenReturn(java.util.Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        // Act: Calling the update method
        productServiceImpl.update(updateProductDto);

        // Assert: Verifying the interactions
        verify(productRepository, times(1)).findById(id);
        verify(productRepository, times(1)).save(any(Product.class));
    }
    @Test
    void whenDeleteCalledWithValidRequest_itShouldDeleteProductFromRepository(){
        when(productRepository.findById(id)).thenReturn(java.util.Optional.of(product));

        // Act: Calling the delete method
        productServiceImpl.delete(deleteProductDto);

        // Assert: Verifying the interactions
        verify(productRepository, times(1)).findById(id);
        verify(productRepository, times(1)).delete(product);
    }


}
