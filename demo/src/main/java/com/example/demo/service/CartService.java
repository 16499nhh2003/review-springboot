package com.example.demo.service;

import com.example.demo.exception.CartException;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.ProductException;
import com.example.demo.model.Cart;
import org.springframework.stereotype.Service;


public interface CartService {

    public Cart addProductToCart(Integer customerId, Long productId)
            throws CartException, CustomerException, ProductException;

    public Cart removeProductFromCart(Integer customerId, Integer productId)
            throws CartException, CustomerException, ProductException;

    public Cart removeAllProduct(Integer customerId) throws CartException, CustomerException;

    public Cart increaseProductQuantity(Integer customerId, Integer productId)
            throws CartException, CustomerException, ProductException;

    public Cart decreaseProductQuantity(Integer customerId, Integer productId)
            throws CartException, CustomerException, ProductException;

}