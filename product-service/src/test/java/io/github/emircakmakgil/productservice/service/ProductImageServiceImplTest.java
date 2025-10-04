package io.github.emircakmakgil.productservice.service;

import io.github.emircakmakgil.productservice.dto.ProductImageDto.CreateProductImageDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.DeleteProductImageDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.UpdateProductImageDto;
import io.github.emircakmakgil.productservice.entity.Product;
import io.github.emircakmakgil.productservice.entity.ProductImage;
import io.github.emircakmakgil.productservice.mapper.ProductImageMapper;
import io.github.emircakmakgil.productservice.repository.ProductImageRepository;
import io.github.emircakmakgil.productservice.service.impl.ProductImageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

import org.reactivestreams.Publisher;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;


@ExtendWith(MockitoExtension.class)
public class ProductImageServiceImplTest {
    @Mock
    private ProductImageService productImageService;
    @Mock
    private ProductService productService;
    @Mock
    private ProductImageRepository productImageRepository;
    @Mock
    private ProductImageMapper productImageMapper;
    @InjectMocks
    private ProductImageServiceImpl productImageServiceImpl;

    private UUID id;
    private UUID productId;
    private CreateProductImageDto createProductImageDto;
    private UpdateProductImageDto updateProductImageDto;
    private DeleteProductImageDto deleteProductImageDto;
    private ProductImage productImage;
    private Product product;

    @BeforeEach
    void setup(){
        id=UUID.randomUUID();
        productId=UUID.randomUUID();
        productImage=new ProductImage();
        productImage.setId(id);
        productImage.setImageUrl("Test URL");
        productImage.setAltText("Test Alt Text");
        productImage.setTitle("Test Title");
        productImage.setHeight(12);
        productImage.setWidth(12);
        productImage.setFileSize(1234L);

        product= new Product();
        product.setId(productId);
        product.setName("Test Product");
        product.setDescription("This is a test product");
        product.setPrice(BigDecimal.valueOf(99.99));
        product.setStockQuantity(100);
        product.setWeight(1.5);
        product.setCategory(null);
        product.setBrand(null);



        createProductImageDto=new CreateProductImageDto();
        createProductImageDto.setProductId(productId);
        createProductImageDto.setImageUrl("Test URL");
        createProductImageDto.setAltText("Test Alt Text");
        createProductImageDto.setTitle("Test Title");
        createProductImageDto.setHeight(12);
        createProductImageDto.setWidth(12);
        createProductImageDto.setFileSize(1234L);



        updateProductImageDto=new UpdateProductImageDto();
        updateProductImageDto.setId(id);
        updateProductImageDto.setProductId(productId);
        updateProductImageDto.setImageUrl("Updated Test URL");
        updateProductImageDto.setAltText("Updated Test Alt Text");
        updateProductImageDto.setTitle("Updated Test Title");
        updateProductImageDto.setHeight(15);
        updateProductImageDto.setWidth(15);
        updateProductImageDto.setFileSize(1500L);

        deleteProductImageDto=new DeleteProductImageDto();
        deleteProductImageDto.setId(id);
    }
    @Test
    void whenAddCalledWithValidRequest_itShouldSaveProductImageToRepository(){
        when(productService.findById(productId)).thenReturn(product);
        when(productImageMapper.createProductImageFromCreateProductImage(createProductImageDto)).thenReturn(productImage);
        when(productImageRepository.save(any())).thenReturn(productImage);

        productImageServiceImpl.add(createProductImageDto);
        verify(productService, times(1)).findById(productId);
        verify(productImageRepository, times(1)).save(any(ProductImage.class));
        verify(productImageMapper, times(1)).createProductImageFromCreateProductImage(createProductImageDto);
       }

    @Test
    void whenUpdateCalledWithValidRequest_itShouldUpdateProductImageInRepository(){
        when(productService.findById(productId)).thenReturn(product);
        when(productImageRepository.findById(id)).thenReturn(Optional.of(productImage));
        when(productImageRepository.save(any())).thenReturn(productImage);

        productImageServiceImpl.update(updateProductImageDto);
        verify(productService, times(1)).findById(productId);
        verify(productImageRepository, times(1)).findById(id);
        verify(productImageRepository, times(1)).save(any(ProductImage.class));
    }
    @Test
    void whenDeleteCalledWithValidRequest_itShouldDeleteProductImageInRepository(){
        when(productImageRepository.findById(id)).thenReturn(Optional.of(productImage));

        productImageServiceImpl.delete(deleteProductImageDto);
        verify(productImageRepository, times(1)).findById(id);
        verify(productImageRepository, times(1)).delete(productImage);
    }


}



