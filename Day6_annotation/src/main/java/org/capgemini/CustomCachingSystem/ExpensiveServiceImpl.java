package org.capgemini.CustomCachingSystem;

public class ExpensiveServiceImpl implements ExpensiveService {
    @Override
    @CacheResult
    public int computeExpensiveOperation(int input) {
        // Simulate an expensive operation
        try {
            Thread.sleep(2000); // 2 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input * input;
    }
}
