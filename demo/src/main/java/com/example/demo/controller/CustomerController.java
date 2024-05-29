package com.example.demo.controller;

import com.example.demo.exception.CustomerException;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    final CustomerService cService;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer c) throws CustomerException {
        return new ResponseEntity<Customer>(cService.addCustomer(c), HttpStatus.OK);
    }


}