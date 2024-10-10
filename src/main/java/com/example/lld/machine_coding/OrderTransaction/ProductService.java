package com.example.lld.machine_coding.OrderTransaction;

import java.util.function.Supplier;

public interface ProductService {
    boolean processPayment(ProductDto product);
    boolean reserveInventory(ProductDto product);
    boolean initiateShipping(ProductDto product);
    void retry(Supplier<Boolean> task, int retries);
}
