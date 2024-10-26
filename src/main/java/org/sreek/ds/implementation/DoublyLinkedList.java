package org.sreek.ds.implementation;

public class DoublyLinkedList<T> {

    //fields
    private int size;
    private Node<T> head;
    private Node<T> tail;

    //constructors

    //insert methods

    //delete methods

    //get

    //contains

    //clear

    // printLinkedList

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
