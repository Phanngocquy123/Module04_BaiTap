package com.example.service;

import com.example.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> showAll();

    void add(Product newProduct);
}
