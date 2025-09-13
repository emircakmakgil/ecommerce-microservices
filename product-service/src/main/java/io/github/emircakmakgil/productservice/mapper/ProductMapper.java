package io.github.emircakmakgil.productservice.mapper;

import io.github.emircakmakgil.productservice.dto.ProductDto.CreateProductDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.ProductListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductDto.UpdateProductDto;
import io.github.emircakmakgil.productservice.entity.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

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
                .build();
    }
    public Product updateProductFromUpdatedProductDto(UpdateProductDto updateProductDto){
        return Product.builder()
                .description(updateProductDto.getDescription())
                .price(updateProductDto.getPrice())
                .stockQuantity(updateProductDto.getStockQuantity())
                .weight(updateProductDto.getWeight())
                .productType(updateProductDto.getProductType())
                .name(updateProductDto.getName()).
                build();
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
