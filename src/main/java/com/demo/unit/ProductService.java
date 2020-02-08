package com.demo.unit;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product queryProduct(String productId) {
        return productRepository.getProductById(productId);
    }
}

