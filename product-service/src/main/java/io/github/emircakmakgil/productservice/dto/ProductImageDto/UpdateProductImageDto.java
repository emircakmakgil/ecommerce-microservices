package io.github.emircakmakgil.productservice.dto.ProductImageDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateProductImageDto {
    private UUID id;
    private UUID productId;
    private String imageUrl;
    private String altText;
    private String title;
    private Integer sortOrder;
    private Boolean isPrimary;
    private Long fileSize;
    private String mimeType;
    private Integer width;
    private Integer height;

}
