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
    public void updateProductAttributeFromUpdateProductAttributeDto(UpdateProductAttirbuteDto updateProductAttirbuteDto, ProductAttribute entity) {
        entity.setAttributeName(updateProductAttirbuteDto.getAttributeName());
        entity.setAttributeValue(updateProductAttirbuteDto.getAttributeValue());
        entity.setUnit(updateProductAttirbuteDto.getUnit());
        entity.setIsFilterable(updateProductAttirbuteDto.getIsFilterable());
        entity.setIsSearchable(updateProductAttirbuteDto.getIsSearchable());
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
