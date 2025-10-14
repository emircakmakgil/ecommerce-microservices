package io.github.emircakmakgil.orderservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_items")
@Getter
@Setter
public class Item {

    @Id
    @UuidGenerator
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;


    //TODO: ASYNC olarak ürün servisten çekilebilir
    @Column(name="product_id")
    private UUID productId;

    //TODO: ASYNC olarak ürün servisten çekilebilir
    @Column(name="product_name")
    private String productName;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subTotal;


}
