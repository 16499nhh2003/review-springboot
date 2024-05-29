package com.example.demo.service.impl;

import com.example.demo.exception.CustomerException;
import com.example.demo.model.Cart;
import com.example.demo.model.Customer;
import com.example.demo.repository.CartRepo;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerServiceImpl implements CustomerService {

    CustomerRepo cRepo;
    CartRepo cartRepo;

    @Override
    public Customer addCustomer(Customer customer) throws CustomerException {
        Cart cart = new Cart();
        customer.setCart(cart);
        cart.setCustomer(customer);
        Customer c = cRepo.save(customer);

        if (c != null) {
            return c;
        } else {
            throw new CustomerException("customer not added");
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerException {
        return null;
    }

    @Override
    public Customer remove(Integer customerId) throws CustomerException {
        return null;
    }

    @Override
    public List<Customer> viewAllCustomer() throws CustomerException {
        return null;
    }
}
