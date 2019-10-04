package com.megafarad;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringOpsTest {

    @Test
    void isPalindrome() {
        assertTrue(StringOps.isPalindrome("RACECAR"));
        assertFalse(StringOps.isPalindrome("ABC"));
    }

    @Test
    void removeChars() {
        assertEquals("RAEAR", StringOps.removeChars('C', "RACECAR"));
    }

    @Test
    void findPermutations() {
        List<String> foundPermutations = StringOps.findPermutations("ABC");
        List<String> expectedPermutations = List.of("ABC", "ACB", "BAC", "BCA", "CAB", "CBA");
        assertEquals(expectedPermutations, foundPermutations);
    }

    @Test
    void reverseStringRecursive() {
        String reversedString = StringOps.reverseStringRecursive("ABCDE");
        assertEquals("EDCBA", reversedString);
    }

    @Test
    void reverseStringIterative() {
        String reversedString = StringOps.reverseStringIterative("ABCDE");
        assertEquals("EDCBA", reversedString);
    }

    @Test
    void isAnagram() {
        assertTrue(StringOps.isAnagram("ABC", "CAB"));
    }

    @Test
    void convertIntegerString() {
        assertEquals(-100, StringOps.convertIntegerString("-100"));
    }
}