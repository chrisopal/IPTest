package com.demo.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {                            //1、测试类


    @Test                                                //2、测试注解
    public void test_sum_of_two_numbers() {              //3、测试方法

        // 准备
        double first = 10;                               //4、测试数据准备
        double second = 20;                              //4、测试数据准备
        Calculator calculator = new Calculator();        //4、测试对象准备

        // 执行
        double result = calculator.sum(first, second);   //5、测试目标方法执行

        // 断言
        assertEquals(30, result);     //6、测试结果断言

    }


    @Test
    public void isDeliveryValid_InvalidDate_ReturnsFalse() {

        DeliveryService sut = new DeliveryService();
        Instant pastDate = Instant.now().minus(1, ChronoUnit.DAYS);
        Delivery delivery = new Delivery(pastDate);

        boolean isValid = sut.isDeliveryValid(delivery);

        Assertions.assertTrue(isValid);
    }


    @Test
    public void test_discount_of_two_products() {

        Product product1 = new Product("Hand Wash");
        Product product2 = new Product("Shampoo");

        PriceEngine sut = new PriceEngine();


        double discount = sut.calculateDiscount(Arrays.asList(product1, product2));

        assertEquals(0.02, discount);
    }

    @Test
    public void test_adding_a_product_to_an_order() {

        Product product = new Product("Hand Wash");

        Order sut = new Order();

        sut.addProduct(product);

        assertEquals(1, sut.getProducts().size());
        assertEquals(product, sut.getProducts().get(0));
    }

    @Mock
    ProductRepository productRepository = Mockito.mock(ProductRepository.class);

    @Test
    public void test_get_users_from_user_service() {

        String productId = "Hand Wash";
        when(productRepository.getProductById(any(String.class)))
                .thenReturn(new Product(productId));


        ProductService sut = new ProductService(productRepository);

        assertEquals(productId, sut.queryProduct(productId).getId());
    }
}

