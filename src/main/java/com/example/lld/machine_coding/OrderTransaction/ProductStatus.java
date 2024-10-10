package com.example.lld.machine_coding.OrderTransaction;

public enum ProductStatus {
    PAYMENT_PENDING, PAYMENT_SUCCESS, PAYMENT_FAILED,
    INVENTORY_PENDING, INVENTORY_SUCCESS, INVENTORY_FAILED,
    SHIPPING_PENDING, SHIPPING_SUCCESS, SHIPPING_FAILED;

    public static boolean isFailed(ProductStatus productStatus) {
        return productStatus.equals(PAYMENT_FAILED) || productStatus.equals(INVENTORY_FAILED) ||productStatus.equals(SHIPPING_FAILED);
    }
}
