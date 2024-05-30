package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "product")
@Embeddable
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Double price;
    private String color;
    private String dimension;
    private String specification;
    private String manufacture;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;


    @ManyToMany(mappedBy = "products" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cart> carts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<CartItem> cartProducts = new HashSet<>();

}
