package com.megafarad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private class Node<E> {
        E element;

        Node<E> left;
        Node<E> right;

        Node(E element) {
            this.element = element;
            left = null;
            right = null;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }
    /**
     * Appends an element to the tree
     *
     * @param element The element to append to the tree
     *
     */
    public void append(E element) {
        logger.info("Appending element: {}", element);
        if (root == null) {
            logger.info("Fresh tree!");
        } else {
            logger.info("Current root before recursion: {}", root.element);
        }
        root = appendRecursive(root, element);
        logger.info("Current root after recursion: {}", root.element);
    }

    private Node<E> appendRecursive(Node<E> currentNode, E element) {

        if (currentNode == null) {
            logger.info("Creating new node for: {}", element);
            return new Node<E>(element);
        }

        if (currentNode.element.compareTo(element) > 0) {
            logger.info("Recurse left @ {}", currentNode.element);
            currentNode.left = appendRecursive(currentNode.left, element);
        } else if (currentNode.element.compareTo(element) < 0) {
            logger.info("Recurse right @ {}", currentNode.element);
            currentNode.right = appendRecursive(currentNode.right, element);
        } else {
            return currentNode;
        }
        return currentNode;
    }


    /**
     * Checks if tree contains an element
     * @param element The element to look for
     * @return true if it is in the tree, false otherwise.
     */
    public boolean contains(E element) {
        return containsRecursive(root, element);
    }

    private boolean containsRecursive(Node<E> currentNode, E element) {
        if (currentNode == null) {
            return false;
        }

        if (currentNode.element.compareTo(element) == 0) {
            return true;
        }
        return currentNode.element.compareTo(element) > 0
                ? containsRecursive(currentNode.left, element)
                : containsRecursive(currentNode.right, element);


    }

    /**
     * Calculates the height of the tree
     * @return The height of the tree
     */
    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node<E> currentNode) {
        if (currentNode == null) {
            return -1;
        } else {
            return 1 + Math.max(heightRecursive(currentNode.left), heightRecursive(currentNode.right));
        }
    }

    public void preOrderTraverse() {
        preOrderTraverseRecursive(root);
    }

    private void preOrderTraverseRecursive(Node<E> node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.element);
            preOrderTraverseRecursive(node.left);
            preOrderTraverseRecursive(node.right);
        }

    }
}
