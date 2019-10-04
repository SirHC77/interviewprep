package com.megafarad;

import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E extends Comparable<E>> {

    private int size = 0;

    private Node head = null;

    private Node tail = null;

    public void push(E element) {
        Node node = new Node(element);
        if (head == null) {
            head = node;
        }
        if (tail == null) {
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    public void insert(E element, int position) {
        Node current = locateNode(position);
        Node newNode = new Node(element);
        Node previousNode = current.previous;
        Node nextNode = current.next;
        if (previousNode == null) {
            //Assume head of list.
            newNode.next = head;
            head = newNode;
        } else {
            //NOT the head.
            previousNode.next = newNode;
            newNode.previous = current;
        }
        if (nextNode == null) {
            //assume tail of list
            newNode.previous = tail;
            tail = newNode;
        } else {
            //NOT the tail
            nextNode.previous = newNode;
            newNode.next = current;
        }

        size++;
    }

    public E pop() {
        Node currentTail = tail;
        if (currentTail == null) {
            return null;
        } else {
            tail = currentTail.previous;
            if (currentTail.previous == null) {
                head = null;
            }
            size--;
            return currentTail.data;
        }
    }

    public E delete(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("must be greater than or equal to zero");
        } else {
            Node current = locateNode(position);
            if (current == null) {
                //perhaps an empty list? whatever...
                return null;
            } else {
                if (current == head) {
                    head = current.next;
                }
                if (current == tail) {
                    tail = current.previous;
                }
                if (current.next != null) {
                    current.next = current.next.next;
                }
                current.previous = current;
                size--;
                return current.data;
            }
        }
    }

    public E get(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("must be greater than or equal to zero");
        } else {
            return locateNode(position).data;
        }
    }

    public int getSize() {
        return size;
    }

    private Node locateNode(int position) {
        Node current = head;
        for (int i = 0; i < position; i++) {
            if (current.next == null) {
                break;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    private class Node {
        E data;
        Node next, previous;

        public Node(E data) {
            this.data = data;
        }

    }

}

