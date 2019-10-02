package com.megafarad;

import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E> {

    private int size = 0;

    private Node<E> head;

    private Node<E> tail;

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }


    private static class Node<E> {


    }

}

