package io.github.emircakmakgil.productservice.dto.InventoryDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateInventoryDto {
    private UUID id;
    private UUID productId;
    private String changeType;
    private Integer quantityChange;
    private Integer previousQuantity;
    private Integer newQuantity;
    private String reason;
    private UUID referenceId;
    private String referenceType;
}
