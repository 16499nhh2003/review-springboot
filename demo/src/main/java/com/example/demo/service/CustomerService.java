package com.example.demo.service;

import com.example.demo.exception.CustomerException;
import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    public Customer addCustomer(Customer customer) throws CustomerException;

    public Customer updateCustomer(Customer customer) throws CustomerException;

    public Customer remove(Integer customerId) throws CustomerException;

    public List<Customer> viewAllCustomer() throws CustomerException;

}