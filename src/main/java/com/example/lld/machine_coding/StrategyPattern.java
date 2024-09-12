package com.example.lld.machine_coding;

import org.springframework.expression.Operation;

import java.util.HashMap;
import java.util.Map;

public class StrategyPattern {
    public static void main(String[] args) {
        Map<String, Operation> operationMap = new HashMap<>();
    }

    private static class AddOperation {
    }

    private static class SubOperation {
    }
}
