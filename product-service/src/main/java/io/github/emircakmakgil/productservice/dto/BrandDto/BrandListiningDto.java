package io.github.emircakmakgil.productservice.dto.BrandDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class BrandListiningDto {
    private String name;
    private String description;
    private String logoUrl;
    private String websiteUrl;
    private String countryOfOrigin;
    private Integer foundedYear;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer productCount;

    public BrandListiningDto() {}

    public BrandListiningDto(String name, String description, String logoUrl, String websiteUrl,
                           String countryOfOrigin, Integer foundedYear, String status, LocalDateTime createdAt,
                           LocalDateTime updatedAt, Integer productCount) {
        this.name = name;
        this.description = description;
        this.logoUrl = logoUrl;
        this.websiteUrl = websiteUrl;
        this.countryOfOrigin = countryOfOrigin;
        this.foundedYear = foundedYear;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productCount = productCount;
    }

}
