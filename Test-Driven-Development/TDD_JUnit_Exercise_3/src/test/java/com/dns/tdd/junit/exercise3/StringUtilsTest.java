package com.dns.tdd.junit.exercise3;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilsTest {
    private StringUtils utils = new StringUtils();

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "madam", "level", "radar", "A man a plan a canal Panama"})
    public void testIsPalindrome(String input) {
        assertTrue(utils.isPalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "world", "java", "testing"})
    public void testIsNotPalindrome(String input) {
        assertFalse(utils.isPalindrome(input));
    }
}
