package com.yc.interviews.truefit;

/**
 * This is an interview question asked me at True Fit corporation in December 2019
 *
 * Create a tree data structure. Each node can have one, two or more children nodes
 * Each node should be able to hold data.
 * And create a print method traversing the tree and printing the data
 */
public class TrueFitTree {

    private Node root;

    private class Node {
        Object item;
        Node[] children;

        public Node(Node[] children) {
            this.children = children;
        }
    }

    public void print() {

    }
}
