package io.github.emircakmakgil.orderservice.dto.OrderDto;

import io.github.emircakmakgil.orderservice.model.enums.OrderStatus;
import io.github.emircakmakgil.orderservice.model.enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class OrderListiningDto {
    private OrderStatus status;
    private PaymentMethod paymentMethod;
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;


    public OrderListiningDto(LocalDateTime orderDate,OrderStatus status, PaymentMethod paymentMethod, BigDecimal totalPrice) {
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }
}
