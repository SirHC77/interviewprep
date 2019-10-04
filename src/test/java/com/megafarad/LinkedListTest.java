package com.megafarad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void push() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.push(1);
        assertEquals(1, testList.getSize());
    }

    @Test
    void insert() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.push(1);
        testList.push(2);
        testList.push(3);
        assertEquals(3, testList.getSize());
        testList.insert(99, 1);
        assertEquals(4, testList.getSize());
        assertEquals(1, testList.get(0));
        assertEquals(99, testList.get(1));
    }

    @Test
    void pop() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.push(1);
        testList.push(2);
        testList.push(3);
        assertEquals(3, testList.pop());
        assertEquals(2, testList.pop());
        assertEquals(1, testList.pop());
        assertEquals(0, testList.getSize());
    }

    @Test
    void delete() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.push(1);
        testList.push(2);
        testList.push(3);
        testList.push(4);
        testList.delete(1);
        assertEquals(4, testList.pop());
        assertEquals(3, testList.pop());
        //Yep, this is broken...
        assertEquals(1, testList.pop());
        assertEquals(3, testList.getSize());
    }

    @Test
    void getSize() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.push(1);
        testList.push(2);
        testList.push(3);
        testList.push(4);
        assertEquals(4, testList.getSize());
    }

    @Test
    void get() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.push(1);
        testList.push(2);
        testList.push(3);
        testList.push(4);
        assertEquals(1, testList.get(0));
        assertEquals(2, testList.get(1));
        assertEquals(3, testList.get(2));
        assertEquals(4, testList.get(3));

    }
}