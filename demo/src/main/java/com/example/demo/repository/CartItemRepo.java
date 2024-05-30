package com.example.demo.repository;


import com.example.demo.model.Cart;
import com.example.demo.model.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {

    @Modifying
    @Transactional
    @Query("update CartItem   set quantity = quantity + 1  where  cart.cartId =  :cartID and  product.productId = :productID ")
    void updateCartItemByCartAndProduct(@Param("cartID") Integer cartID, @Param("productID") Long productID);


    @Query("SELECT ci FROM CartItem ci WHERE ci.cart.cartId = :cartId AND ci.product.productId = :productId")
    Optional<CartItem> findByCartIdAndProductId(@Param("cartId") Integer cartId, @Param("productId") Long productId);

    List<CartItem> findAllByCart(Cart cart);

    @Modifying
    @Transactional
    @Query("DELETE FROM CartItem ci WHERE ci.cart.cartId = :cartId")
    void deleteAllByCart(@Param("cartId") Integer cartId);
}
