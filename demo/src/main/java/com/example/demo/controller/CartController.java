package com.example.demo.controller;


import com.example.demo.exception.CartException;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.ProductException;
import com.example.demo.model.Cart;
import com.example.demo.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartController {

    CartService cService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addProductToCart(@RequestParam("customerId") Integer cId,
                                                 @RequestParam("productId") Long productId) throws CartException, CustomerException, ProductException {
        return new ResponseEntity<Cart>(cService.addProductToCart(cId, productId), HttpStatus.OK);

    }


}
