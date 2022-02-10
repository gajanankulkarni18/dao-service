package com.upgraddemo.daoservice.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.upgraddemo.daoservice.entity.Product;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(long id);

    Product createProduct(Product product);

    Product updateProduct(long id, Product product);

    HttpStatus deleteProduct(long id);
}
