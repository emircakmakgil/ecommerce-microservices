package io.github.emircakmakgil.orderservice.entity;

import io.github.emircakmakgil.orderservice.model.enums.OrderStatus;
import io.github.emircakmakgil.orderservice.model.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
public class Order {
    @Id
    @UuidGenerator
    private UUID id;

    //TODO: Foreign Key olarak bağlanabilir
    @Column(nullable = false)
    private UUID customerId;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status = OrderStatus.PENDING; // Başlangıç durumu

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;


    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "order_date", updatable = false)
    private LocalDateTime orderDate;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> orderItems;
}





