package io.github.emircakmakgil.productservice.repository;

import io.github.emircakmakgil.productservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {
}
