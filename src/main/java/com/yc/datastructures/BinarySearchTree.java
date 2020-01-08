package com.yc.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private class Node {
        private int key;
        private LinkedList<Object> items;
        private Node left;
        private Node right;

        private Node(int key, Object data) {
            this(key, data, null, null);
        }

        private Node(int key, Object data, Node left, Node right) {
            this.key = key;
            this.items = new LinkedList<>();
            if (data != null) {
                this.items.add(data);
            }
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key, Object data) {
        Node parent = null;
        Node trav = root;

        while (trav != null) {
            if (key == trav.key) {
                trav.items.add(data);
            }
            parent = trav;

            if (key < trav.key) {
                trav = trav.left;
            } else {
                trav = trav.right;
            }
        }

        Node node = new Node(key, data);
        if (parent == null) {
            root = node;
        } else if (key < parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    }

    public LinkedList<Object> remove(int key) {
        Node parent = null;
        Node trav = root;

        while (trav != null && key != trav.key) {
            parent = trav;
            if (key < trav.key) {
                trav = trav.left;
            } else {
                trav = trav.right;
            }
        }

        if (trav == null) {
            return null;
        } else {
            LinkedList removedData = trav.items;
            deleteNode(trav, parent);
            return removedData;
        }
    }

    private void deleteNode(Node toDelete, Node parent) {
        if (toDelete.left != null && toDelete.right != null) {
            throw new UnsupportedOperationException("Not yet implemented");
        } else {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    public LinkedList<Object> search(int key) {
        Node n = searchTree(key, root);
        return (n == null ? null : n.items);
    }

    private Node searchTree(int key, Node root) {
        if (root == null) {
            return null;
        } else if (key == root.key) {
            return root;
        } else if (key < root.key) {
            return searchTree(key, root.left);
        } else {
            return searchTree(key, root.right);
        }
    }

    public void preOrderPrint() {
        if (root != null) {
            preOrderPrintTree(root);
        }
    }

    private static void preOrderPrintTree(Node root) {
        System.out.print(root.key + " ");
        if (root.left != null) {
            preOrderPrintTree(root.left);
        }
        if (root.right != null) {
            preOrderPrintTree(root.right);
        }
    }

    public void levelOrderPrint() {
        if (root != null) {
            levelOrderQueue.add(root);
            levelOrderPrintTree();
        }
    }

    private Queue<Node> levelOrderQueue = new LinkedList<>();
    private void levelOrderPrintTree() {
        while (!levelOrderQueue.isEmpty()) {
            Node node = levelOrderQueue.remove();
            System.out.print(node.key + " ");
            if (node.left != null) {
                levelOrderQueue.add(node.left);
            }
            if (node.right != null) {
                levelOrderQueue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(26,"a");
        tree.insert(12, "b");
        tree.insert(32, "c");
        tree.insert(4, "d");
        tree.insert(18, "e");
        tree.insert(38, "f");
        tree.insert(7, "g");
        tree.insert(35, "h");

        System.out.println("Pre-order Print");
        tree.preOrderPrint();
        System.out.println("\nLevel-order Print");
        tree.levelOrderPrint();
        System.out.println();

        tree.remove(26);

    }
}
