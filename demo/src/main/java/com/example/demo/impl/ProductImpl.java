package com.example.demo.impl;

import com.example.demo.dto.request.ProductRequest;
import com.example.demo.dto.response.ResponseResponse;
import com.example.demo.exception.ProductException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ProductImpl implements ProductService {

    final ProductRepository productRepository;
    final ModelMapper modelMapper;

    @Override
    public List<Product> getAll() throws ProductException {
        List<Product> products = productRepository.findAll();
        if (products.size() > 0) {
            return products;
        } else {

            throw new ProductException("Products not found");
        }
    }

    @Override
    public Product addProduct(ProductRequest productRequest) throws ProductException {
        Product product = modelMapper.map(productRequest, Product.class);
        Product newProduct = productRepository.save(product);
        if (newProduct != null) {
            return newProduct;
        } else {
            throw new ProductException("Product not added");
        }
    }

    @Override
    public void deleteProduct(Long id) throws ProductException {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findUserById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Product updateProduct(String id, ProductRequest productRequest) throws ProductException {
        Long productId;
        try {
            productId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new ProductException("Invalid product ID format");
        }
        Optional<Product> productOptional = this.productRepository.findById(productId);
        if (!productOptional.isPresent()) {
            throw new ProductException("Product not found");
        }
        Product p = modelMapper.map(productRequest, Product.class);
        p.setProductId(Long.parseLong(id));
        Product updatedProduct = this.productRepository.save(p);
        return updatedProduct;
    }

}
