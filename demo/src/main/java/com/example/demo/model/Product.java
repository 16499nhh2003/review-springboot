package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Primary;

@Entity(name = "product")
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

}
