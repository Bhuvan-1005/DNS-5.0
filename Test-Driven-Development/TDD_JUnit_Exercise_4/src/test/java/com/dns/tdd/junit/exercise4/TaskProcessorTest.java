package com.dns.tdd.junit.exercise4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.Test;

public class TaskProcessorTest {
    private TaskProcessor processor = new TaskProcessor();

    @Test
    public void testProcessWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> processor.process(null));
    }

    @Test
    public void testProcessWithEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> processor.process(""));
    }

    @Test
    public void testExecuteWithDelay() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            String result = processor.executeWithDelay("test");
            assertEquals("Executed: test", result);
        });
    }
}
