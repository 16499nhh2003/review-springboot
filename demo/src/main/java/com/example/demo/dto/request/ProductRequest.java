package com.example.demo.dto.request;


import com.example.demo.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private Double price;
    private String color;
    private String dimension;
    private String specification;
    private String manufacture;

    private Category category;

}
