package com.example.service.impl;

import com.example.entity.Product;
import com.example.repository.impl.Repository;
import com.example.service.ProductService;

import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private Repository<Product, String> productRepository;

    public ProductServiceImpl() {
        this.productRepository = new Repository<>();
    }

    @Override
    public List<Product> showAll() {
        List<Product> productList = productRepository.findAll(Product.class);

        return productList;
    }



    @Override
    public void add(Product newProduct) {
            try {
                productRepository.add(newProduct);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
