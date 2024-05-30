package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@ToString
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    private Integer product_quantity;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @JsonIgnore
    @ToString.Exclude
    private List<Product> products = new ArrayList<Product>();

    @JsonIgnore
    @OneToMany(mappedBy = "cart")
    @ToString.Exclude
    private Set<CartItem> cartProducts = new HashSet<CartItem>();

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Customer customer;


}
