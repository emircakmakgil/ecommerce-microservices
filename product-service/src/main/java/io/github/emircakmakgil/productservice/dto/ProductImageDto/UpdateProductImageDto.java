package io.github.emircakmakgil.productservice.dto.ProductImageDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateProductImageDto {
    private UUID id;
    private String imageUrl;
    private String altText;
    private String title;
    private Long fileSize;
    private Integer width;
    private Integer height;

}
