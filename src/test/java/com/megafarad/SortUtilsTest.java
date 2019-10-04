package com.megafarad;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortUtilsTest {

    private Logger logger = LoggerFactory.getLogger(SortUtilsTest.class);

    @Test
    void bubbleSort() {
        Integer[] sortableArray = new Integer[]{9,1,2,6,8,3,5,4,7,0};
        Integer[] expectedArray = new Integer[]{0,1,2,3,4,5,6,7,8,9};
        SortUtils.bubbleSort(sortableArray);
        assertArrayEquals(expectedArray, sortableArray);
    }

    @Test
    void quickSort() {
        Integer[] sortableArray = new Integer[]{9,1,2,6,8,3,5,4,7,0};
        Integer[] expectedArray = new Integer[]{0,1,2,3,4,5,6,7,8,9};
        SortUtils.quickSort(sortableArray);
        assertArrayEquals(expectedArray, sortableArray);
    }



}