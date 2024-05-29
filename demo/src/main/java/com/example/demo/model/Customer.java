package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cId;
    private String fName;
    private String lName;
    private String mobile;
    private String email;
    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;


}
