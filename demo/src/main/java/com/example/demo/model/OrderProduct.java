package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "order_product")
public class OrderProduct {

    @EmbeddedId
    private OrderProductKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Orders order;


    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @JoinColumn(name = "quantity")
    private Integer quantity;

}
