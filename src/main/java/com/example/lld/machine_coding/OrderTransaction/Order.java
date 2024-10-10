package com.example.lld.machine_coding.OrderTransaction;

import java.util.Map;

public class Order {
    Integer id;
    Map<Integer, ProductDto> productDtoMap;
    Map<Integer, ProductDto> failedProductMap;
    OrderStatus orderStatus;
}
