package io.github.emircakmakgil.productservice.mapper;

import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.CreateProductAttirbuteDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.ProductAttirbuteListiningDto;
import io.github.emircakmakgil.productservice.dto.ProductAttirbuteDto.UpdateProductAttirbuteDto;
import io.github.emircakmakgil.productservice.entity.ProductAttribute;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductAttirbuteMapper {
    public ProductAttribute createProductAttributeFromCreateProductAttributeDto(CreateProductAttirbuteDto createProductAttirbuteDto){
        return ProductAttribute
                .builder()
                .attributeName(createProductAttirbuteDto.getAttributeName())
                .attributeValue(createProductAttirbuteDto.getAttributeValue())
                .unit(createProductAttirbuteDto.getUnit())
                .isSearchable(createProductAttirbuteDto.getIsSearchable())
                .isFilterable(createProductAttirbuteDto.getIsFilterable())
                .build();
    }
    public ProductAttribute updateProductAttributeFromUpdateProductAttributeDto(UpdateProductAttirbuteDto updateProductAttirbuteDto){
        return ProductAttribute
                .builder()
                .attributeName(updateProductAttirbuteDto.getAttributeName())
                .attributeValue(updateProductAttirbuteDto.getAttributeValue())
                .unit(updateProductAttirbuteDto.getUnit())
                .isFilterable(updateProductAttirbuteDto.getIsFilterable())
                .isSearchable(updateProductAttirbuteDto.getIsSearchable())
                .build();
    }
    public ProductAttirbuteListiningDto toProductAttributeListiningDto(ProductAttribute productAttribute){
        return new ProductAttirbuteListiningDto(productAttribute.getAttributeName(),
                productAttribute.getAttributeValue(),
                productAttribute.getUnit(),
                productAttribute.getIsSearchable(),
                productAttribute.getIsFilterable(),
                productAttribute.getCreatedAt(),
                productAttribute.getUpdatedAt());
    }
}
