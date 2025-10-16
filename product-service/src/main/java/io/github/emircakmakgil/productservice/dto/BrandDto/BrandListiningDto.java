package io.github.emircakmakgil.productservice.dto.BrandDto;

import io.github.emircakmakgil.productservice.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

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
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BrandListiningDto() {}

    public BrandListiningDto(String name, String description, String logoUrl, String websiteUrl,
                             String countryOfOrigin, Integer foundedYear, Status status) {
        this.name = name;
        this.description = description;
        this.logoUrl = logoUrl;
        this.websiteUrl = websiteUrl;
        this.countryOfOrigin = countryOfOrigin;
        this.foundedYear = foundedYear;
        this.status = status;
    }

}
