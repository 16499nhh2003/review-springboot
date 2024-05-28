package com.example.demo.dto.request;


import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private Double price;
    private String color;
    private String dimension;
    private String specification;
    private String manufacture;

}
