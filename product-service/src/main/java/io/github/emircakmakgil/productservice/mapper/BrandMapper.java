package io.github.emircakmakgil.productservice.mapper;

import io.github.emircakmakgil.productservice.dto.BrandDto.BrandListiningDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.CreateBrandDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.UpdateBrandDto;
import io.github.emircakmakgil.productservice.entity.Brand;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
    public void updateBrandFromUpdateBrandDto(UpdateBrandDto updateBrandDto, Brand brand) {
                brand.setName(updateBrandDto.getName());
                brand.setDescription(updateBrandDto.getDescription());
                brand.setCountryOfOrigin(updateBrandDto.getCountryOfOrigin());
                brand.setLogoUrl(updateBrandDto.getLogoUrl());
                brand.setWebsiteUrl(updateBrandDto.getWebsiteUrl());
                brand.setFoundedYear(updateBrandDto.getFoundedYear());
                brand.setStatus(updateBrandDto.getStatus());
                brand.setUpdatedAt(LocalDateTime.now());
    }
    public BrandListiningDto toBrandListiningDto(Brand brand){
        return new BrandListiningDto(
                brand.getName(),
                brand.getDescription(),
                brand.getLogoUrl(),
                brand.getWebsiteUrl(),
                brand.getCountryOfOrigin(),
                brand.getFoundedYear(),
                brand.getStatus());
    }

}
