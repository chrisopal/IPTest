package com.demo.unit;

import java.util.List;

public class PriceEngine {

    public double calculateDiscount(List<Product> products) {

        double discount = products.size() * 0.01;
        return Math.min(discount, 0.2);
    }
}


