package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
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


    @ManyToMany(mappedBy = "productList")
    @JsonIgnore
    private Set<Cart> carts = new HashSet<>();

}
