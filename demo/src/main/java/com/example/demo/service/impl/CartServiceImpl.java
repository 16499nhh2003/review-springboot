package com.example.demo.service.impl;

import com.example.demo.exception.CartException;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.ProductException;
import com.example.demo.model.Cart;
import com.example.demo.model.CartItem;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.repository.CartItemRepo;
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
import java.util.Set;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CartServiceImpl implements CartService {
    CartRepo cartRepo;
    CustomerRepo crRepo;
    ProductRepository pRepo;
    CartItemRepo cartItemRepo;

    static Logger logger = Logger.getLogger(CartServiceImpl.class.getName());

    @Override
    public Cart addProductToCart(Integer customerId, Long productId) throws CartException, CustomerException, ProductException {
        try {
            Optional<Customer> opt = crRepo.findById(customerId);

            if (opt.isEmpty()) throw new CustomerException("Customer not found!");


            Optional<Product> itemOpt = pRepo.findById(productId);
            if (itemOpt.isEmpty()) throw new ProductException("Product not found!");


            Product product = itemOpt.get();
            Customer customer = opt.get();
            Cart cart = customer.getCart();

            List<Product> itemList = cart.getProducts();
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
                cart.getProducts().add(itemOpt.get());
            }

            Optional<CartItem> cartItemOpt = this.cartItemRepo.findByCartIdAndProductId(cart.getCartId(), productId);
            if (cartItemOpt.isPresent()) {
                cartItemRepo.updateCartItemByCartAndProduct(cart.getCartId(), productId);
            } else {
                CartItem cartItem = new CartItem();
                cartItem.setCart(cart);
                cartItem.setProduct(product);
                cartItem.setQuantity(1);
                cartItemRepo.save(cartItem);
                cart.getCartProducts().add(cartItem);
            }

            this.cartRepo.save(cart);
            return cart;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Cart removeProductFromCart(Integer customerId, Long productId) throws CartException, CustomerException, ProductException {
//        Optional<Customer> opt = crRepo.findById(customerId);
//
//        if (opt.isEmpty())
//            throw new CustomerException("Customer not found!");
//
//        Optional<Product> itemOpt = pRepo.findById(productId);
//        if (itemOpt.isEmpty())
//            throw new ProductException("Product not found!");
//
//        Customer customer = opt.get();
//        Cart cart = customer.getCart();
//        List<Product> itemList = cart.getProducts();
//        boolean flag = false;
//        for (int i = 0; i < itemList.size(); i++) {
//            Product element = itemList.get(i);
//            if (element.getProductId() == productId) {
//                itemList.remove(element);
//                flag = true;
//                break;
//            }
//        }
//        if (!flag) {
//            throw new CartException("Product not removed from cart");
//        }
//        cart.setProducts(itemList);
//        cRepo.save(cart);
//        return cart;
        return null;
    }

    @Override
    public Cart removeAllProduct(Integer customerId) throws CartException, CustomerException {
//        Optional<Customer> opt = crRepo.findById(customerId);
//        if (opt.isEmpty())
//            throw new CustomerException("Customer not found!");
//        Cart c = opt.get().getCart();
//        if (c == null) {
//            throw new CartException("cart not found");
//        }
//        c.getProducts().clear();
//        return cRepo.save(c);
        return null;

    }

    @Override
    public Cart increaseProductQuantity(Integer customerId, Long productId) throws CartException, CustomerException, ProductException {
//        Optional<Customer> opt = crRepo.findById(customerId);
//		if (opt.isEmpty())
//			throw new CustomerException("Customer not found!");
//
//		Optional<Product> itemOpt = pRepo.findById(productId);
//		if (itemOpt.isEmpty())
//			throw new ProductException("Product not found!");
//
//		Customer customer = opt.get();
//		Cart cart = customer.getCart();
//		List<Product> itemList = cart.getProducts();
//		boolean flag = true;
//		for (int i = 0; i < itemList.size(); i++) {
//			Product element = itemList.get(i);
//			if (element.getProductId() == productId) {
//				cart.setProduct_quantity(cart.getProduct_quantity() + 1);
//				flag = false;
//			}
//		}
//		if (flag) {
//			cart.getProducts().add(itemOpt.get());
//		}
//
//		cRepo.save(cart);
//		return cart;
        return null;
    }

    @Override
    public Cart decreaseProductQuantity(Integer customerId, Long productId) throws CartException, CustomerException, ProductException {
//        Optional<Customer> opt = crRepo.findById(customerId);
//		if (opt.isEmpty())
//			throw new CustomerException("Customer not found!");
//
//		Optional<Product> itemOpt = pRepo.findById(productId);
//		if (itemOpt.isEmpty())
//			throw new ProductException("Product not found!");
//
//		Customer customer = opt.get();
//		Cart cart = customer.getCart();
//		List<Product> itemList = cart.getProducts();
//		boolean flag = true;
//		if (itemList.size() > 0) {
//			for (int i = 0; i < itemList.size(); i++) {
//				Product element = itemList.get(i);
//				if (element.getProductId() == productId) {
//					cart.setProduct_quantity(cart.getProduct_quantity() - 1);
//					flag = false;
//				}
//			}
//		}
//
//		if (flag) {
//			cart.getProducts().add(itemOpt.get());
//		}
//
//		cRepo.save(cart);
//		return cart;
        return null;
    }
}
