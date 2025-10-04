package io.github.emircakmakgil.productservice.entity;

import jakarta.persistence.*;
import lombok.*;
import io.github.emircakmakgil.productservice.model.enums.Status;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.URL;

import java.net.ProtocolFamily;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    @Id
    @UuidGenerator
    private UUID id;
    
    @Column(nullable = false, unique = true)
    private String name;


    private String description;
    
    @Column(name = "logo_url")
    @URL(message = "Invalid URL format")
    private String logoUrl;
    
    @Column(name = "website_url")
    @URL(message = "Invalid URL format")
    private String websiteUrl;
    
    @Column(name = "country_of_origin")
    private String countryOfOrigin;
    
    @Column(name = "founded_year")
    private Integer foundedYear;
    
    @OneToMany(mappedBy = "brand")
    private List<Product> products;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;


}
