package io.github.emircakmakgil.orderservice.dto.OrderDto;
import io.github.emircakmakgil.orderservice.model.enums.OrderStatus;
import io.github.emircakmakgil.orderservice.model.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateOrderDto {
    private UUID id;
    private UUID customerId;
    private OrderStatus status = OrderStatus.PENDING;
    private PaymentMethod paymentMethod;
}
