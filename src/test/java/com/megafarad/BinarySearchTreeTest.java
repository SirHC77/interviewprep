package com.megafarad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void append() {
        BinarySearchTree<Integer> test = new BinarySearchTree<>();

        test.append(1);
        test.append(3);
        test.append(100);
        //No exceptions...
    }

    @Test
    void contains() {
        BinarySearchTree<Integer> test = new BinarySearchTree<>();
        test.append(1);
        test.append(100);
        test.append(3);

        assertTrue(test.contains(1));
        assertTrue(test.contains(100));
        assertTrue(test.contains(3));
        assertFalse(test.contains(0));

    }

    @Test
    void height() {
        BinarySearchTree<Integer> test = new BinarySearchTree<>();
        test.append(5);
        test.append(10);
        test.append(1);
        test.append(3);
        test.append(20);
        assertEquals(2, test.height());
    }
}