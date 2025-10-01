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
    public ProductImage createProductImageFromCreateProductImage(CreateProductImageDto createProductImageDto){
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
    public void updateProductImageFromUpdatedProductImage(UpdateProductImageDto updateProductImageDto, ProductImage productImage) {

                productImage.setImageUrl(updateProductImageDto.getImageUrl());
                productImage.setAltText(updateProductImageDto.getAltText());
                productImage.setTitle(updateProductImageDto.getTitle());
                productImage.setFileSize(updateProductImageDto.getFileSize());
                productImage.setWidth(updateProductImageDto.getWidth());
                productImage.setHeight(updateProductImageDto.getHeight());
                productImage.setUpdatedAt(LocalDateTime.now());
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
