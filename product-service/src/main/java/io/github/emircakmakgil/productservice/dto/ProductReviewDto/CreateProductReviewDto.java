package io.github.emircakmakgil.productservice.dto.ProductReviewDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateProductReviewDto {
    private UUID productId;
    private UUID userId;
    private Integer rating;
    private String title;
    private String comment;
    private Boolean isVerifiedPurchase;
}
