package com.example.demo.service;


import com.example.demo.dto.request.ProductRequest;
import com.example.demo.exception.ProductException;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> getAll() throws ProductException;

    Product addProduct(ProductRequest product) throws ProductException;

    void deleteProduct(Long id) throws ProductException;

    Optional<Product> findUserById(Long id);

    Product updateProduct(String id , ProductRequest productRequest) throws ProductException;
}
