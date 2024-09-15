package com.example.lld.machine_coding;

public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }

    private interface Strategy {
        int doOperation(int num1, int num2);
    }

    private static class OperationAdd implements Strategy {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 + num2;
        }
    }

    private static class OperationSubtract implements Strategy {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 - num2;
        }
    }

    private static class OperationMultiply implements Strategy {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 * num2;
        }
    }

    private static class Context {
        private final Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public int executeStrategy(int num1, int num2) {
            return strategy.doOperation(num1, num2);
        }
    }
}