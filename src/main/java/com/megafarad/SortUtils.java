package com.megafarad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortUtils {

    public static Logger logger = LoggerFactory.getLogger(SortUtils.class);

    public static <E extends Comparable<E>> void bubbleSort(E[] arrayToSort) {
        int numElements = arrayToSort.length;

        for (int i = 0; i < numElements - 1; i++) {
            for (int j = 0; j < numElements - i - 1; j++) {
                if (arrayToSort[j].compareTo(arrayToSort[j + 1]) > 0) {
                    swap(arrayToSort, j, j + 1);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void quickSort(E[] arrayToSort) {
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
    }

    private static <E extends Comparable<E>> void quickSort(E[] arrayToSort, int leftIdx, int rightIdx) {
        logger.info("Calling quicksort on array: {} with left: {} and right: {}", arrayToSort, leftIdx, rightIdx);
        if (leftIdx >= rightIdx) {
            return;
        }
        E pivot = arrayToSort[(leftIdx + rightIdx) / 2];
        logger.info("pivot: {}", pivot);
        int newPivotPoint = partition(arrayToSort, leftIdx, rightIdx, pivot);
        logger.info("new pivot point: {}", newPivotPoint);
        quickSort(arrayToSort, leftIdx, newPivotPoint - 1);
        quickSort(arrayToSort, newPivotPoint, rightIdx);
    }

    private static <E extends Comparable<E>> int partition(E[] array, int leftIdx, int rightIdx, E pivot) {
        while (leftIdx <= rightIdx) {
            while (array[leftIdx].compareTo(pivot) < 0) {
                leftIdx++;
            }
            while (array[rightIdx].compareTo(pivot) > 0) {
                rightIdx--;
            }
            if (leftIdx <= rightIdx) {
                swap(array, leftIdx, rightIdx);
                leftIdx++;
                rightIdx--;
            }
        }
        return leftIdx;
    }


    private static <E extends Comparable<E>> void swap(E[] array, int indexA, int indexB) {
        E tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }




}
