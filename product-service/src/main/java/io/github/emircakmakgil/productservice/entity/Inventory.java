package io.github.emircakmakgil.productservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import io.github.emircakmakgil.productservice.model.enums.ChangeType;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "inventories")
@Getter
@Setter
public class Inventory {
    @Id
    @UuidGenerator
    private UUID id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "change_type", nullable = false)
    private ChangeType changeType;
    
    @Column(name = "quantity_change", nullable = false)
    private Integer quantityChange;
    
    @Column(name = "previous_quantity")
    private Integer previousQuantity;
    
    @Column(name = "new_quantity")
    private Integer newQuantity;
    
    @Column(name = "reason", columnDefinition = "TEXT")
    private String reason;
    
    @Column(name = "reference_id")
    private UUID referenceId;
    
    @Column(name = "reference_type")
    private String referenceType; // ORDER, RETURN, MANUAL_ADJUSTMENT
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
