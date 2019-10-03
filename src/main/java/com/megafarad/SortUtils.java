package com.megafarad;

public class SortUtils {

    public static <E extends Comparable<E>> void bubbleSort(E[] arrayToSort) {
        int numElements = arrayToSort.length;

        for (int i = 0; i < numElements - 1; i++) {
            for (int j = 0; j < numElements - i - 1; j++) {
                if (arrayToSort[j].compareTo(arrayToSort[j + 1]) > 0) {
                    E tmp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = tmp;
                }
            }
        }
    }

}
