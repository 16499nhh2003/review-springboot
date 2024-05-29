package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer catId;
    private String categoryName;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL , mappedBy =  "category")
    private List<Product> productList;

}
