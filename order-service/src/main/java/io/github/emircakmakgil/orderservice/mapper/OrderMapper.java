package io.github.emircakmakgil.orderservice.mapper;

import io.github.emircakmakgil.orderservice.dto.OrderDto.CreateOrderDto;
import io.github.emircakmakgil.orderservice.dto.OrderDto.OrderListiningDto;
import io.github.emircakmakgil.orderservice.entity.Order;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderMapper {
    public Order createOrderFromCreatedOrder(CreateOrderDto createOrderDto){
        return Order.builder()
                .customerId(createOrderDto.getCustomerId())
                .status(createOrderDto.getStatus())
                .paymentMethod(createOrderDto.getPaymentMethod())
                .build();
    }
    public void updateOrderFromCreateOrderDto(CreateOrderDto createOrderDto, Order order) {
        order.setCustomerId(createOrderDto.getCustomerId());
        order.setStatus(createOrderDto.getStatus());
        order.setPaymentMethod(createOrderDto.getPaymentMethod());
    }
    public OrderListiningDto toOrderListiningDto(Order order){
        return new OrderListiningDto(
                order.getOrderDate(),
                order.getStatus(),
                order.getPaymentMethod(),
                order.getTotalPrice());
    }
}
