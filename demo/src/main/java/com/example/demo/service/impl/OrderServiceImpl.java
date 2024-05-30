package com.example.demo.service.impl;

import com.example.demo.exception.CartException;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.OrderException;
import com.example.demo.model.*;
import com.example.demo.repository.CartItemRepo;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.OrderProductRepo;
import com.example.demo.repository.OrderRepo;
import com.example.demo.service.OrderService;
import jakarta.persistence.criteria.Order;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.*;
import java.time.LocalDateTime;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderServiceImpl implements OrderService {
    OrderRepo oRepo;
    CustomerRepo customerRepo;
    OrderProductRepo orderProductRepo;
    CartItemRepo cartItemRepo;

    static Logger logger = Logger.getLogger(OrderServiceImpl.class.getName());

    @Override
    public Orders addOrder(Integer cid) throws OrderException, CustomerException, CartException {
        try {
            Optional<Customer> opt = customerRepo.findById(cid);
            if (opt.isEmpty()) {
                throw new CustomerException("Customer not found");
            }
            Customer c = opt.get();
            Cart cart = c.getCart();
            if (cart == null)
                throw new CartException("Cart empty");

            List<CartItem> cartItems = this.cartItemRepo.findAllByCart(cart);

            // persist data
            Orders o = new Orders();
            o.setDate(LocalDateTime.now());
            o.setOrderStatus("Pending");
            o.setAddress(c.getAddress());
            o.setCustomer(c);
            Orders savedOrder = oRepo.save(o);


            List<OrderProduct> orderProducts = new ArrayList<>();
            for (CartItem cartItem : cartItems) {
                OrderProduct orderProduct = new OrderProduct();
                OrderProductKey orderProductKey = new OrderProductKey();
                orderProductKey.setOrderId(savedOrder.getOrderId());
                orderProductKey.setProductId(cartItem.getProduct().getProductId());
                orderProduct.setProduct(cartItem.getProduct());
                orderProduct.setId(orderProductKey);
                orderProduct.setOrder(savedOrder);
                orderProduct.setQuantity(cartItem.getQuantity());
                orderProducts.add(orderProduct);
            }

            savedOrder.setOrderProducts(orderProducts);
//            this.oRepo.save(savedOrder);


            // delete cartItem
            System.err.println(cart.getCartId());
            this.cartItemRepo.deleteAllByCart(cart.getCartId());


            return savedOrder;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Orders updateOrder(Orders order) throws OrderException {
        return null;
    }

    @Override
    public Orders viewOrder(Integer orderId) throws OrderException {
        Optional<Orders> orders = this.oRepo.findById(orderId);

        if (orders.isEmpty())
            throw new OrderException("khong thay don hang");

        return orders.get();
    }

    @Override
    public List<Orders> viewAllOrder() throws OrderException {

        return null;
    }

    @Override
    public List<Orders> viewAllOrdersByUserId(Integer userId) throws OrderException {
        return null;
    }
}
