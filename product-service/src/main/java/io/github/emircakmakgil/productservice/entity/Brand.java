package io.github.emircakmakgil.productservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import io.github.emircakmakgil.productservice.model.enums.Status;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "brands")
@Getter
@Setter
public class Brand {
    @Id
    @UuidGenerator
    private UUID id;
    
    @Column(nullable = false, unique = true)
    private String name;


    private String description;
    
    @Column(name = "logo_url")
    private String logoUrl;
    
    @Column(name = "website_url")
    private String websiteUrl;
    
    @Column(name = "country_of_origin")
    private String countryOfOrigin;
    
    @Column(name = "founded_year")
    private Integer foundedYear;
    
    @OneToMany(mappedBy = "brand")
    private List<Product> products;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

}
