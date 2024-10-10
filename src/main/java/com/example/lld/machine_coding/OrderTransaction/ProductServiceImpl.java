package com.example.lld.machine_coding.OrderTransaction;

import java.util.function.Supplier;

public class ProductServiceImpl implements ProductService {
    @Override
    public boolean processPayment(ProductDto product) {
        long start = System.currentTimeMillis();
        boolean paymentStatus = ProcessUtils.processProb();
        synchronized (product.productId) {
            product.productStatus = paymentStatus ? ProductStatus.PAYMENT_SUCCESS : ProductStatus.PAYMENT_FAILED;
        }
        Long timeTaken = System.currentTimeMillis() - start;
        return paymentStatus;
    }

    @Override
    public boolean reserveInventory(ProductDto product) {
        product.productStatus = ProductStatus.INVENTORY_PENDING;
        long start = System.currentTimeMillis();
        boolean paymentStatus = ProcessUtils.processProb();
        synchronized (product.productId) {
            product.productStatus = paymentStatus ? ProductStatus.INVENTORY_SUCCESS : ProductStatus.INVENTORY_FAILED;
        }
        Long timeTaken = System.currentTimeMillis() - start;
        return paymentStatus;
    }

    @Override
    public boolean initiateShipping(ProductDto product) {
        product.productStatus = ProductStatus.INVENTORY_PENDING;
        long start = System.currentTimeMillis();
        boolean paymentStatus = ProcessUtils.processProb();
        synchronized (product.productId) {
            product.productStatus = paymentStatus ? ProductStatus.SHIPPING_SUCCESS : ProductStatus.SHIPPING_FAILED;
        }
        Long timeTaken = System.currentTimeMillis() - start;
        return paymentStatus;
    }

    @Override
    public void retry(Supplier<Boolean> task, int retries) {
        for (int i = 0; i < retries; i++) {
            if (task.get()) {
                return;
            }
        }
    }


}
