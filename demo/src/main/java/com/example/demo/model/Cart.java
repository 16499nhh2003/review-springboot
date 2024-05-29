package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    private Integer product_quantity;


    @ManyToMany
    @JoinTable(
            name = "cart_product_list",
            joinColumns = @JoinColumn(name = "cart_cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_list_product_id")
    )
    private List<Product> productList;


    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;


}
