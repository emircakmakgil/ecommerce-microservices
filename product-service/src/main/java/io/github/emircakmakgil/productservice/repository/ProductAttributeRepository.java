package io.github.emircakmakgil.productservice.repository;

import io.github.emircakmakgil.productservice.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, UUID> {
}
