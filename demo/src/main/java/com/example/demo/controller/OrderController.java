package com.example.demo.controller;

import com.example.demo.exception.CartException;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.OrderException;
import com.example.demo.exception.ProductException;
import com.example.demo.model.Orders;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {

    OrderService oService;

    @PostMapping("/add")
    public ResponseEntity<Orders> addOrder(@RequestParam("customerId") Integer customerId)
            throws OrderException, CustomerException, CartException, ProductException {
        return new ResponseEntity<Orders>( oService.addOrder(customerId), HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) throws OrderException {
        return new ResponseEntity<Orders>(oService.updateOrder(order), HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Orders> viewOrderById(@PathVariable("id") Integer orderId) throws OrderException {
        return new ResponseEntity<Orders>(oService.viewOrder(orderId), HttpStatus.OK);
    }

    @GetMapping("/view")
    public ResponseEntity<List<Orders>> viewAllOrder() throws OrderException {
        return new ResponseEntity<List<Orders>>(oService.viewAllOrder(), HttpStatus.OK);
    }

//    @GetMapping("/view/{userId}")
//    public ResponseEntity<List<Orders>> viewOrderByUserId(@PathVariable("userId") Integer userId)
//            throws OrderException {
//        return new ResponseEntity<List<Orders>>(oService.viewAllOrdersByUserId(userId), HttpStatus.OK);
//    }
}