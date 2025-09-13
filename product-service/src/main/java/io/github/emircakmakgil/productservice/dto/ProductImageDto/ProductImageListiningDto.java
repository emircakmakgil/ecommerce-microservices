package io.github.emircakmakgil.productservice.dto.ProductImageDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductImageListiningDto {

    private String imageUrl;
    private String altText;
    private String title;
    private Integer sortOrder;
    private Boolean isPrimary;
    private Long fileSize;
    private String mimeType;
    private Integer width;
    private Integer height;


    public ProductImageListiningDto() {}

    public ProductImageListiningDto( String imageUrl, String altText,
                                  String title,  Long fileSize,
                                  Integer width, Integer height) {

        this.imageUrl = imageUrl;
        this.altText = altText;
        this.title = title;
        this.fileSize = fileSize;
        this.width = width;
        this.height = height;

    }

}
