package io.github.emircakmakgil.productservice.repository;

import io.github.emircakmakgil.productservice.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductReviewRepositorty extends JpaRepository<ProductReview, UUID> {
}
