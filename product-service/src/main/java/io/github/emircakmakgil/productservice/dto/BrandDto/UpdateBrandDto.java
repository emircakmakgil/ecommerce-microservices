package io.github.emircakmakgil.productservice.dto.BrandDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateBrandDto {
    private UUID id;
    private String name;
    private String description;
    private String logoUrl;
    private String websiteUrl;
    private String countryOfOrigin;
    private Integer foundedYear;
    private String status;

}
