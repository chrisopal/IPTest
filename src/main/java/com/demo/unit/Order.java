package com.demo.unit;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {

        this.products.add(product);
    }
}


