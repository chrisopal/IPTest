package com.demo.unit;

public class ProductRepository {

    public Product getProductById(String id) {

        return new Product(id);
    }
}
