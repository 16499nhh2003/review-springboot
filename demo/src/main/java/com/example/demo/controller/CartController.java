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
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/remove/{cartId}/{productId}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable("cartId") Integer cartId,
                                                      @PathVariable("productId") Long productId) throws CartException, CustomerException, ProductException {
        return new ResponseEntity<Cart>(cService.removeProductFromCart(cartId, productId), HttpStatus.OK);
    }


    @DeleteMapping("/remove/{cartId}")
    public ResponseEntity<Cart> removeAllProduct(@PathVariable("cartId") Integer cartId)
            throws CartException, CustomerException {
        return new ResponseEntity<Cart>(cService.removeAllProduct(cartId), HttpStatus.OK);
    }

    @PutMapping("/increase/{cartId}/{productId}")
    public ResponseEntity<Cart> increaseProductQuantity(@PathVariable("cartId") Integer cartId,
                                                        @PathVariable("productId") Long productId) throws CartException, CustomerException, ProductException {
        return new ResponseEntity<Cart>(cService.increaseProductQuantity(cartId, productId), HttpStatus.OK);
    }

    @PutMapping("/decrease/{cartId}/{productId}")
    public ResponseEntity<Cart> decreaseProductQuantity(@PathVariable("cartId") Integer cartId,
                                                        @PathVariable("productId") Long productId) throws CartException, CustomerException, ProductException {
        return new ResponseEntity<Cart>(cService.decreaseProductQuantity(cartId, productId), HttpStatus.OK);
    }


}
