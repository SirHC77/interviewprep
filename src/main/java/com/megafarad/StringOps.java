package com.megafarad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StringOps {

    public StringOps() {
        /* prevent instantiation. */
    }

    /**
     * Checks to see if the string is a palindrome
     *
     * @param testString The string to check
     * @return true if a palindrome, false if not
     */
    public static boolean isPalindrome(String testString) {
        StringBuilder reverseString = new StringBuilder(testString);
        reverseString.reverse();
        return testString.equals(reverseString.toString());
    }

    /**
     * Removes all instances of a specific unwanted character from a string
     *
     * @param unwantedChar The character to remove
     * @param string The string to strip unwanted characters from
     * @return The string without the unwanted character
     */
    public static String removeChars(char unwantedChar, String string) {
        char[] stringChars = string.toCharArray();
        StringBuilder returnString = new StringBuilder();
        for (char stringChar : stringChars) {
            if (stringChar != unwantedChar) {
                returnString.append(stringChar);
            }
        }
        return returnString.toString();
    }

    /**
     * Finds all permutations for a given string
     * @param string The string to build permutations
     * @return The list of all permutations of a given string
     */
    public static List<String> findPermutations(String string) {
        ArrayList<String> returnList = new ArrayList<>();
        populatePermutations(returnList, "", string);
        return returnList;
    }

    private static void populatePermutations(ArrayList<String> permutations, String permutation, String word) {
        if (word.isEmpty()) {
            permutations.add(permutation);
        } else {
            for (int i = 0; i < word.length(); i++) {
                populatePermutations(permutations, permutation + word.charAt(i),
                        word.substring(0, i) + word.substring(i + 1));
            }
        }
    }

    public static String reverseStringRecursive(String string) {
        if (string.isEmpty()) {
            return string;
        } else {
            return reverseStringRecursive(string.substring(1)) + string.substring(0,1);
        }
    }

    public static String reverseStringIterative(String string) {

        //Yes, this is bad form. StringBuilder is best for this case; however, that can also reverse strings, too.
        //So... it's kinda silly to instantiate a StringBuilder without using its reverse method for a method that
        //reverses a string.

        String returnString = "";

        for (int i = string.length() - 1; i >= 0; i--) {
            returnString = returnString + string.charAt(i);
        }
        return returnString;
    }

    public static boolean isAnagram(String stringA, String stringB) {
        if (stringA == null || stringB == null || stringA.length() != stringB.length() || stringA.isEmpty()) {
            return false;
        } else {
            char[] stringAchars = stringA.toCharArray();
            char[] stringBchars = stringB.toCharArray();
            Arrays.sort(stringAchars);
            Arrays.sort(stringBchars);
            return Arrays.equals(stringAchars, stringBchars);
        }


    }

    public static int convertIntegerString(String integerString) {
        return Integer.parseInt(integerString);
    }

}
