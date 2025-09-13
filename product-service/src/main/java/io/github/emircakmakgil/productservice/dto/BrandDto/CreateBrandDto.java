package io.github.emircakmakgil.productservice.dto.BrandDto;

import io.github.emircakmakgil.productservice.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBrandDto {

    private String name;
    private String description;
    private String logoUrl;
    private String websiteUrl;
    private String countryOfOrigin;
    private Integer foundedYear;
    private Status status;

}
