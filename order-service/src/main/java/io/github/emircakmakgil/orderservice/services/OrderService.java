package io.github.emircakmakgil.orderservice.services;

import io.github.emircakmakgil.orderservice.dto.OrderDto.CreateOrderDto;
import io.github.emircakmakgil.orderservice.dto.OrderDto.DeleteOrderDto;
import io.github.emircakmakgil.orderservice.dto.OrderDto.OrderListiningDto;
import io.github.emircakmakgil.orderservice.dto.OrderDto.UpdateOrderDto;
import io.github.emircakmakgil.orderservice.entity.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<Order> findAll(List<UUID> order);
    Order findById(UUID id);
    void add(CreateOrderDto createOrderDto);
    List<OrderListiningDto> getAll();
    Order update(UpdateOrderDto updateOrderDto);
    void delete(DeleteOrderDto deleteOrderDto);
}
