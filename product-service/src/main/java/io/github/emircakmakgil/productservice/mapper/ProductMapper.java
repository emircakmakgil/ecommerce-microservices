package io.github.emircakmakgil.productservice.mapper;

import io.github.emircakmakgil.productservice.dto.ProductDto.CreateProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.ProductListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.UpdateProductDto;
import io.github.emircakmakgil.productservice.entity.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class ProductMapper {
    public Product createProductFromCreateProductDto(CreateProductDto createProductDto){
        return Product
                .builder()
                .name(createProductDto.getName())
                .description(createProductDto.getDescription())
                .price(createProductDto.getPrice())
                .stockQuantity(createProductDto.getStockQuantity())
                .weight(createProductDto.getWeight())
                .productType(createProductDto.getProductType())
                .createdAt(LocalDateTime.now())
                .status(createProductDto.getStatus())
                .build();
    }
    public void updateProductFromUpdatedProductDto(UpdateProductDto updateProductDto, Product product){
                product.setDescription(updateProductDto.getDescription());
                product.setPrice(updateProductDto.getPrice());
                product.setStockQuantity(updateProductDto.getStockQuantity());
                product.setWeight(updateProductDto.getWeight());
                product.setProductType(updateProductDto.getProductType());
                product.setName(updateProductDto.getName());
                product.setUpdatedAt(LocalDateTime.now());
                product.setCreatedAt(LocalDateTime.now());

    }
    public ProductListiningDto toProductListiningDto(Product product){
        return new ProductListiningDto(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getWeight(),
                product.getStatus(),
                product.getProductType()
        );
    }


}
