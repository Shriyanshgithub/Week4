package org.capgemini.CustomCachingSystem;

public class Main {
    public static void main(String[] args) {
        ExpensiveService service = new ExpensiveServiceImpl();
        ExpensiveService proxy = CachingProxy.createProxy(service);

        System.out.println("First call: " + proxy.computeExpensiveOperation(5));
        System.out.println("Second call: " + proxy.computeExpensiveOperation(5));
        System.out.println("Third call with different input: " + proxy.computeExpensiveOperation(10));
    }
}

