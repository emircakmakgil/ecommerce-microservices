package io.github.emircakmakgil.orderservice.repository;

import io.github.emircakmakgil.orderservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}
