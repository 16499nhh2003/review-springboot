package com.example.demo.repository;


import com.example.demo.model.OrderProduct;
import com.example.demo.model.OrderProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepo extends JpaRepository<OrderProduct, OrderProductKey> {
}
