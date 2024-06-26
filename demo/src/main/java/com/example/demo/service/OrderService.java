package com.example.demo.service;

import com.example.demo.exception.CartException;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.OrderException;
import com.example.demo.model.Orders;

import java.util.List;

public interface OrderService {
    public Orders addOrder(Integer cid) throws OrderException, CustomerException, CartException;

    public Orders updateOrder(Orders order) throws OrderException;

    public Orders viewOrder(Integer orderId) throws OrderException;

    public List<Orders> viewAllOrder() throws OrderException;

    public List<Orders> viewAllOrdersByUserId(Integer userId) throws OrderException;
}
