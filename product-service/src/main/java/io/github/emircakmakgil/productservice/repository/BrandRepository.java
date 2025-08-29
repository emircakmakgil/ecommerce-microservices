package io.github.emircakmakgil.productservice.repository;

import io.github.emircakmakgil.productservice.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
}
