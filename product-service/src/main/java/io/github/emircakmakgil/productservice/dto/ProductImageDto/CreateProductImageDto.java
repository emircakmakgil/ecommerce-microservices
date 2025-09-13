package io.github.emircakmakgil.productservice.dto.ProductImageDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
public class CreateProductImageDto {
    private UUID productId;
    private String imageUrl;
    private String altText;
    private String title;
    private Long fileSize;
    private Integer width;
    private Integer height;
    private LocalDateTime createdAt;

}
