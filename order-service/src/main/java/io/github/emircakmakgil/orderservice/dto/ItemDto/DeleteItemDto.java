package io.github.emircakmakgil.orderservice.dto.ItemDto;

import java.util.UUID;

public class DeleteItemDto {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
