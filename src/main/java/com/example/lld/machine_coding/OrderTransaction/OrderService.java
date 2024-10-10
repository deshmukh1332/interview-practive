package com.example.lld.machine_coding.OrderTransaction;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.example.lld.machine_coding.OrderTransaction.ProductStatus.isFailed;

public class OrderService {

    public Map<Integer, ProductDto> createOrder(Map<Product, Integer> productMap) {
        Map<Integer, ProductDto> productDtoMap = new HashMap<>();
        productMap.forEach((product, value) -> productDtoMap.putIfAbsent(product.id, new ProductDto(product.id,
                                                                                                    value)));
        Order order = new Order();
        order.productDtoMap = productDtoMap;
        order.orderStatus = OrderStatus.PENDING;
        return productDtoMap;
    }

    public void processOrder(Order order) {
        ExecutorService executors = Executors.newFixedThreadPool(4);
        for (ProductDto productDto : order.productDtoMap.values()) {
            executors.submit(() -> process(productDto));
        }
        int countOfFailed =
            (int) order.productDtoMap.values().stream().filter(productDto -> isFailed(productDto.productStatus)).count();
        if (countOfFailed == order.productDtoMap.size()) {
            order.orderStatus = OrderStatus.FAILED;
        } else if (countOfFailed == 0) {
            order.orderStatus = OrderStatus.SUCCESSFUL;
        } else {
            order.orderStatus = OrderStatus.SUCCESSFUL;
        }
    }

    private void process(ProductDto productDto) {
        ProductService productService = new ProductServiceImpl();
        productService.retry(() -> productService.processPayment(productDto), 3);
        productService.retry(() -> productService.reserveInventory(productDto), 3);
        productService.retry(() -> productService.initiateShipping(productDto), 3);
    }
}
