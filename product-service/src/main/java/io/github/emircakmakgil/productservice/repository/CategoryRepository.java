package io.github.emircakmakgil.productservice.repository;

import io.github.emircakmakgil.productservice.dto.CategoryDto.CategoryListiningDto;
import io.github.emircakmakgil.productservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findByName(String name);
}
