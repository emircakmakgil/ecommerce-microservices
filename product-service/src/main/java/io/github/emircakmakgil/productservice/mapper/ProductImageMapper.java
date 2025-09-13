package io.github.emircakmakgil.productservice.mapper;

import io.github.emircakmakgil.productservice.dto.ProductImageDto.CreateProductImageDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.ProductImageListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductImageDto.UpdateProductImageDto;
import io.github.emircakmakgil.productservice.entity.ProductImage;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ProductImageMapper {
    public ProductImage createProductImageFromCreateProductImageUrl(CreateProductImageDto createProductImageDto){
        return ProductImage.builder()
                .imageUrl(createProductImageDto.getImageUrl())
                .altText(createProductImageDto.getAltText())
                .title(createProductImageDto.getTitle())
                .fileSize(createProductImageDto.getFileSize())
                .width(createProductImageDto.getWidth())
                .height(createProductImageDto.getHeight())
                .createdAt(java.time.LocalDateTime.now())
                .build();
    }
    public ProductImage updateProductImageFromUpdatedProductImage(UpdateProductImageDto updateProductImageDto){
        return ProductImage.builder()
                .imageUrl(updateProductImageDto.getImageUrl())
                .altText(updateProductImageDto.getAltText())
                .title(updateProductImageDto.getTitle())
                .fileSize(updateProductImageDto.getFileSize())
                .width(updateProductImageDto.getWidth())
                .height(updateProductImageDto.getHeight())
                .updatedAt(LocalDateTime.now())
                .build();
    }
    public ProductImageListiningDto toProductImageListiningDto(ProductImage productImage){
        return new ProductImageListiningDto(
                productImage.getImageUrl(),
                productImage.getAltText(),
                productImage.getTitle(),
                productImage.getFileSize(),
                productImage.getWidth(),
                productImage.getHeight()
        );
    }
}
