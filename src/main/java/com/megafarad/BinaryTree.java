package com.megafarad;

public class BinaryTree<E extends Comparable<E>> {

    private Node<E> root;


    public void append(E element) {
        this.root = appendRecursive(this.root, element);
    }


    public boolean contains(E element) {
        return containsRecursive(this.root, element);
    }

    private <ET extends Comparable<ET>> boolean containsRecursive(Node<ET> currentNode, ET element) {
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


    private <ET extends Comparable<ET>> Node<ET> appendRecursive(Node<ET> currentNode, ET element) {

        if (currentNode == null) {
            return new Node<>(element);
        }

        if (currentNode.element.compareTo(element) > 0) {
            currentNode.left = appendRecursive(currentNode.left, element);
        } else if (currentNode.element.compareTo(element) < 0) {
            currentNode.right = appendRecursive(currentNode.right, element);
        }
        return currentNode;
    }

    private static class Node<E extends Comparable<E>> {
        E element;

        Node left;
        Node right;

        Node(E element) {
            this.element = element;
            left = null;
            right = null;
        }
    }
}
