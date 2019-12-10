package com.yc.datastructures;

public class SinglyLinkedList implements MyList {

    Node first = null;

    private class Node {
        Object element;
        Node next;

        public Node(Object element) {
            this.element = element;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
    }

    public boolean add(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("List do not accept null objects");
        }

        if (first == null) {
            first = new Node(element);
        } else {
            Node trav = first;
            while (trav.next != null) {
                trav = trav.next;
            }
            trav.next = new Node(element);
        }

        return true;
    }

    public boolean remove(Object element) {
        return true;
    }

    public boolean contains(Object element) {
        if (element == null) {
            return false;
        }

        Node trav = first;
        while (trav.next != null) {
            if (trav.element.equals(element)) {
                return true;
            }
            trav = trav.next;
        }
        return false;
    }
}
