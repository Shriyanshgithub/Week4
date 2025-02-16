package org.capgemini.Problem_7;

public class LongRunningTask {
    public String executeTask() {
        try {
            Thread.sleep(3000); // Simulating a long-running task (3 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupt status
        }
        return "Task Completed";
    }
}

