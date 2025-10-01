package io.github.emircakmakgil.productservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "product_images")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    
    @Column(name = "alt_text")
    private String altText;
    
    @Column(name = "title")
    private String title;

    @Column(name = "file_size")
    private Long fileSize;
    @Column(name = "width")
    private Integer width;
    
    @Column(name = "height")
    private Integer height;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


}
