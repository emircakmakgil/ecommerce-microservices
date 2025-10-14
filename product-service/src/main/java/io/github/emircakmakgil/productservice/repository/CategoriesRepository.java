package io.github.emircakmakgil.productservice.repository;

import io.github.emircakmakgil.productservice.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoriesRepository extends CrudRepository<Categories, UUID> {
}
