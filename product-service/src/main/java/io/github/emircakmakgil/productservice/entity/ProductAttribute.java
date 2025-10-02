package io.github.emircakmakgil.productservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "product_attributes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttribute {
    @Id
    @UuidGenerator
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    @Column(name = "attribute_name")
    private String attributeName;
    
    @Column(name = "attribute_value", columnDefinition = "TEXT")
    private String attributeValue;

    @Column(name = "unit")
    private String unit; // kg, cm, inch, etc.
    
    @Column(name = "is_searchable")
    private Boolean isSearchable;
    
    @Column(name = "is_filterable")
    private Boolean isFilterable;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
