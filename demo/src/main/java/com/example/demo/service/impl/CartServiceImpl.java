package com.example.demo.service.impl;

import com.example.demo.exception.CartException;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.ProductException;
import com.example.demo.model.Cart;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.repository.CartRepo;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CartServiceImpl implements CartService {
    private CartRepo cRepo;
    private CustomerRepo crRepo;
    private ProductRepository pRepo;


    private static final Logger LOGGER = Logger.getLogger(CartServiceImpl.class.getName());

    @Override
    public Cart addProductToCart(Integer customerId, Long productId) throws CartException, CustomerException, ProductException {

        Optional<Customer> opt = crRepo.findById(customerId);

        if (opt.isEmpty())
            throw new CustomerException("Customer not found!");


        Optional<Product> itemOpt = pRepo.findById(productId);
        if (itemOpt.isEmpty())
            throw new ProductException("Product not found!");

        Customer customer = opt.get();
        Cart cart = customer.getCart();

        List<Product> itemList = cart.getProductList();
        boolean flag = true;

        for (int i = 0; i < itemList.size(); i++) {
            Product element = itemList.get(i);
            if (element.getProductId() == productId) {
                if (cart.getProduct_quantity() == null) {
                    cart.setProduct_quantity(1);

                } else {
                    cart.setProduct_quantity(cart.getProduct_quantity() + 1);
                }

                flag = false;
            }
        }
        if (flag) {
            cart.getProductList().add(itemOpt.get());
        }


        cRepo.save(cart);
        return cart;

    }

    @Override
    public Cart removeProductFromCart(Integer customerId, Integer productId) throws CartException, CustomerException, ProductException {
        return null;
    }

    @Override
    public Cart removeAllProduct(Integer customerId) throws CartException, CustomerException {
        return null;
    }

    @Override
    public Cart increaseProductQuantity(Integer customerId, Integer productId) throws CartException, CustomerException, ProductException {
        return null;
    }

    @Override
    public Cart decreaseProductQuantity(Integer customerId, Integer productId) throws CartException, CustomerException, ProductException {
        return null;
    }
}
