package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> saveAll(List<Product> products);
    List<Product> findAll();
    Product findById(Long id);
    void deleteById(Long id);
}
