package io.github.emircakmakgil.productservice.dto.InventoryDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class InventoryListiningDto {
    private String productName;
    private String changeType;
    private Integer quantityChange;
    private Integer previousQuantity;
    private Integer newQuantity;
    private String reason;
    private UUID referenceId;
    private String referenceType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public InventoryListiningDto() {}

    public InventoryListiningDto(String productName, String changeType, Integer quantityChange,
                               Integer previousQuantity, Integer newQuantity, String reason, UUID referenceId,
                               String referenceType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.productName = productName;
        this.changeType = changeType;
        this.quantityChange = quantityChange;
        this.previousQuantity = previousQuantity;
        this.newQuantity = newQuantity;
        this.reason = reason;
        this.referenceId = referenceId;
        this.referenceType = referenceType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
