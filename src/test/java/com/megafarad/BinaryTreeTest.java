package com.megafarad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void append() {
        BinaryTree<Integer> test = new BinaryTree<>();

        test.append(1);
        test.append(3);
        test.append(100);
        //No exceptions...
    }

    @Test
    void contains() {
        BinaryTree<Integer> test = new BinaryTree<>();
        test.append(1);
        test.append(100);
        test.append(3);

        assertTrue(test.contains(1));
        assertTrue(test.contains(100));
        assertTrue(test.contains(3));
        assertFalse(test.contains(0));

    }
}