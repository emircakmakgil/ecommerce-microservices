package io.github.emircakmakgil.productservice.entity;

import io.github.emircakmakgil.productservice.model.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;
import io.github.emircakmakgil.productservice.model.enums.Status;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String name;
    
    private String description;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private Double price;
    
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;
    

    
    @Column(name = "weight")
    private Double weight;
    

    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductImage> images;
    

    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "productType", nullable = false)
    private ProductType productType;

}
