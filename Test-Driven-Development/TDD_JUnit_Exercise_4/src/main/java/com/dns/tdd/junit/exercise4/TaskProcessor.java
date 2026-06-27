package com.dns.tdd.junit.exercise4;

public class TaskProcessor {
    public void process(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input must not be null or empty");
        }
    }

    public String executeWithDelay(String task) throws InterruptedException {
        Thread.sleep(500);
        return "Executed: " + task;
    }
}
