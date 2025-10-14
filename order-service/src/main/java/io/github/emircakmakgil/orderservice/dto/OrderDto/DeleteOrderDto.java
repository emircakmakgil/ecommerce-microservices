package io.github.emircakmakgil.orderservice.dto.OrderDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DeleteOrderDto {
    private UUID id;
}
