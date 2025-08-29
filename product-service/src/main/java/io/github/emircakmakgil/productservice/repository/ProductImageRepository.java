package io.github.emircakmakgil.productservice.repository;

import io.github.emircakmakgil.productservice.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductImageRepository extends JpaRepository<ProductImage, UUID> {
}
