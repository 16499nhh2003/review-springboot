package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private LocalDateTime date;
    private String orderStatus;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @ElementCollection
    private List<Product> productList;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


}
