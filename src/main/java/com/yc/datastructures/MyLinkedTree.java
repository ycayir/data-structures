package com.yc.datastructures;

import java.util.LinkedList;

public class MyLinkedTree {
    private class Node {
        private int key;
        private LinkedList data;
        private Node left;
        private Node right;
    }

    private Node root;

    public MyLinkedTree() {}

    public void add() {

    }

    public void preOrderPrint() {
        if (root != null) {
            preOrderPrintTree(root);
        }
    }

    private static void preOrderPrintTree(Node root) {
        System.out.println(root.key + " ");    // visit node
        if (root.left != null) {
            preOrderPrintTree(root.left);
        }
        if (root.right != null) {
            preOrderPrintTree(root.right);
        }
    }

    public void postOrderPrint() {
        if (root != null) {
            postOrderPrintTree(root);
        }
    }

    private static void postOrderPrintTree(Node root) {
        if (root.left != null) {
            postOrderPrintTree(root.left);
        }
        if (root.right != null) {
            postOrderPrintTree(root.right);
        }
        System.out.println(root.key + " ");    // visit node
    }

    public void inOrderPrint() {
        if (root != null) {
            inOrderPrintTree(root);
        }
    }

    private static void inOrderPrintTree(Node root) {
        if (root.left != null) {
            inOrderPrintTree(root.left);
        }
        System.out.println(root.key + " ");    // visit node
        if (root.right != null) {
            inOrderPrintTree(root.right);
        }
    }

    public void levelOrderTraversal() {
        if (root != null) {
            levelOrderTraversalTree(root);
        }
    }

    /**
     * This operation is suitable to Breadth First Search (BFS) strategy
     * This method can be implemented using a Queue
     * @param root
     */
    private void levelOrderTraversalTree(Node root) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
