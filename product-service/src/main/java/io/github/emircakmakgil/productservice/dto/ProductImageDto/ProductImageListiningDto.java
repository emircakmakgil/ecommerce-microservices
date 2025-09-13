package io.github.emircakmakgil.productservice.dto.ProductImageDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductImageListiningDto {

    private String productName;
    private String imageUrl;
    private String altText;
    private String title;
    private Integer sortOrder;
    private Boolean isPrimary;
    private Long fileSize;
    private String mimeType;
    private Integer width;
    private Integer height;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductImageListiningDto() {}

    public ProductImageListiningDto(String productName, String imageUrl, String altText,
                                  String title, Integer sortOrder, Boolean isPrimary, Long fileSize, String mimeType,
                                  Integer width, Integer height, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.productName = productName;
        this.imageUrl = imageUrl;
        this.altText = altText;
        this.title = title;
        this.sortOrder = sortOrder;
        this.isPrimary = isPrimary;
        this.fileSize = fileSize;
        this.mimeType = mimeType;
        this.width = width;
        this.height = height;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
