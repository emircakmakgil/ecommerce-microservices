package io.github.emircakmakgil.productservice.service;

import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.CreateProductAttirbuteDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.DeleteProductAttirbuteDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.UpdateProductAttirbuteDto;
import io.github.emircakmakgil.productservice.entity.Product;
import io.github.emircakmakgil.productservice.entity.ProductAttribute;
import io.github.emircakmakgil.productservice.mapper.ProductAttirbuteMapper;
import io.github.emircakmakgil.productservice.repository.ProductAttributeRepository;
import io.github.emircakmakgil.productservice.service.impl.ProductAttirbuteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ProductAttirbuteServiceImplTest {
    @Mock
    private ProductAttirbuteMapper productAttirbuteMapper;
    @Mock
    private ProductAttributeRepository productAttributeRepository;
    @Mock
    private ProductService productService;
    @InjectMocks
    private ProductAttirbuteServiceImpl productAttirbuteServiceImpl;

    private UUID id;
    private CreateProductAttirbuteDto createProductAttirbuteDto;
    private UpdateProductAttirbuteDto updateProductAttirbuteDto;
    private DeleteProductAttirbuteDto deleteProductAttirbuteDto;
    private UUID productId;
    private Product product;
    private ProductAttribute productAttribute;
    @BeforeEach
    void setup(){
        id= UUID.randomUUID();
        productId=UUID.randomUUID();

        productAttribute=new ProductAttribute();
        productAttribute.setId(id);
        productAttribute.setAttributeName("Color");
        productAttribute.setUnit("Piece");
        productAttribute.setAttributeValue("Red");
        productAttribute.setIsFilterable(true);
        productAttribute.setIsSearchable(false);
        productAttribute.setProduct(product);

        createProductAttirbuteDto=new CreateProductAttirbuteDto();
        createProductAttirbuteDto.setProductId(productId);
        createProductAttirbuteDto.setAttributeName("Color");
        createProductAttirbuteDto.setUnit("Piece");
        createProductAttirbuteDto.setAttributeValue("Red");
        createProductAttirbuteDto.setIsFilterable(true);
        createProductAttirbuteDto.setIsSearchable(false);


        updateProductAttirbuteDto=new UpdateProductAttirbuteDto();
        updateProductAttirbuteDto.setId(id);
        updateProductAttirbuteDto.setProductId(productId);
        updateProductAttirbuteDto.setAttributeName("Size");
        updateProductAttirbuteDto.setUnit("Piece");
        updateProductAttirbuteDto.setAttributeValue("Medium");
        updateProductAttirbuteDto.setIsFilterable(false);
        updateProductAttirbuteDto.setIsSearchable(true);

        deleteProductAttirbuteDto=new DeleteProductAttirbuteDto();
        deleteProductAttirbuteDto.setId(id);

        product= new Product();
        product.setId(productId);
        product.setName("Test Product");
        product.setDescription("This is a test product");
        product.setPrice(BigDecimal.valueOf(99.99));
        product.setStockQuantity(100);
        product.setWeight(1.5);
        product.setCategory(null);
        product.setBrand(null);

    }
    @Test
    void whenAddCalledWithValidRequest_itShouldSaveProductAttributeToRepository(){
     when(productService.findById(productId)).thenReturn(product);
     when(productAttirbuteMapper.createProductAttributeFromCreateProductAttributeDto(createProductAttirbuteDto)).thenReturn(productAttribute);
        when(productAttributeRepository.save(any())).thenReturn(productAttribute);

        // Act: Calling the add method
        productAttirbuteServiceImpl.add(createProductAttirbuteDto);
        // Assert: Verifying the interactions
        verify(productService, times(1)).findById(productId);
        verify(productAttirbuteMapper, times(1)).createProductAttributeFromCreateProductAttributeDto(createProductAttirbuteDto);
        verify(productAttributeRepository, times(1)).save(any(ProductAttribute.class));
    }
    @Test
    void whenUpdateCalledWithValidRequest_itShouldUpdateProductAttributeInRepository(){
        when(productService.findById(productId)).thenReturn(product);
        when(productAttributeRepository.findById(id)).thenReturn(Optional.of(productAttribute));
        when(productAttributeRepository.save(any())).thenReturn(productAttribute);

        // Act: Calling the add method
        productAttirbuteServiceImpl.update(updateProductAttirbuteDto);
        // Assert: Verifying the interactions
        verify(productService, times(1)).findById(productId);
        verify(productAttributeRepository, times(1)).findById(id);
        verify(productAttributeRepository, times(1)).save(any(ProductAttribute.class));
    }
    @Test
    void whenDeleteCalledWithValidRequest_itShouldDeleteProductAttributeInRepository(){
        when(productAttributeRepository.findById(id)).thenReturn(Optional.of(productAttribute));

        // Act: Calling the add method
        productAttirbuteServiceImpl.delete(deleteProductAttirbuteDto);
        // Assert: Verifying the interactions
        verify(productAttributeRepository, times(1)).findById(id);
        verify(productAttributeRepository, times(1)).delete(productAttribute);
    }

}
