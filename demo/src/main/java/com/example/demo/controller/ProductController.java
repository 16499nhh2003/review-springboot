package com.example.demo.controller;


import com.example.demo.dto.request.ProductRequest;
import com.example.demo.dto.response.ResponseResponse;
import com.example.demo.exception.ProductException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    final ProductService productService;
    final ModelMapper modelMapper;
    private final static Logger logger = Logger.getLogger(ProductController.class.getName());

    @GetMapping
    public ResponseEntity<List<Product>> getAll() throws ProductException {
        return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseResponse> addProduct(@RequestBody ProductRequest productReq) throws ProductException {
        Product product = productService.addProduct(productReq);
        return new ResponseEntity<ResponseResponse>(modelMapper.map(product, ResponseResponse.class), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) throws ProductException {
        System.out.println(id);
        productService.deleteProduct(id);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestParam(name = "id") String id, @RequestBody ProductRequest productRequest) {
        Product response = null;
        logger.info(productRequest.toString());
        try {
            response = productService.updateProduct(id, productRequest);
            return new ResponseEntity<Product>(response, HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<Product>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
