package io.github.emircakmakgil.productservice.mapper;

import io.github.emircakmakgil.productservice.dto.BrandDto.BrandListiningDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.CreateBrandDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.UpdateBrandDto;
import io.github.emircakmakgil.productservice.entity.Brand;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BrandMapper {
    public Brand createBrandFromCreateBrandDto(CreateBrandDto createBrandDto){
        return Brand.builder()
                .name(createBrandDto.getName())
                .description(createBrandDto.getDescription())
                .countryOfOrigin(createBrandDto.getCountryOfOrigin())
                .logoUrl(createBrandDto.getLogoUrl())
                .websiteUrl(createBrandDto.getWebsiteUrl())
                .foundedYear(createBrandDto.getFoundedYear())
                .status(createBrandDto.getStatus())
                .build();
    }
    public Brand updateBrandFromUpdateBrandDto(UpdateBrandDto updateBrandDto){
       return Brand.builder()
               .name(updateBrandDto.getName())
               .description(updateBrandDto.getDescription())
               .countryOfOrigin(updateBrandDto.getCountryOfOrigin())
               .logoUrl(updateBrandDto.getLogoUrl())
               .websiteUrl(updateBrandDto.getWebsiteUrl())
               .foundedYear(updateBrandDto.getFoundedYear())
               .status(updateBrandDto.getStatus())
               .build();
    }
    public BrandListiningDto toBrandListiningDto(Brand brand){
        return new BrandListiningDto(
                brand.getName(),
                brand.getDescription(),
                brand.getLogoUrl(),
                brand.getWebsiteUrl(),
                brand.getCountryOfOrigin(),
                brand.getFoundedYear(),
                brand.getStatus(),
                brand.getCreatedAt(),
                brand.getUpdatedAt());
    }

}
