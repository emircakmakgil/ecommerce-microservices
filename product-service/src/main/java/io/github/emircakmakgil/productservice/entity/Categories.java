package io.github.emircakmakgil.productservice.entity;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

@RedisHash("Categories") // Redis'te "Categories" adlı bir hash (küme) olarak saklanacak entity değilde böyle
@Data
@EqualsAndHashCode
public class Categories implements Serializable {

    @Id
    @UuidGenerator
    private UUID id;


    private String name;
    private String description;
}
