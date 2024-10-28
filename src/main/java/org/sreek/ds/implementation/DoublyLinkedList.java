package org.sreek.ds.implementation;

public class DoublyLinkedList<T> {

    //fields
    private int size;
    private Node<T> head;
    private Node<T> tail;

    //constructors
    public DoublyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public DoublyLinkedList(T data) {
        this.size = 1;

        Node<T> newNode = new Node<>(null, data, null);
        this.tail = this.head = newNode;
    }

    public DoublyLinkedList(DoublyLinkedList<T> linkedList) {
        if(linkedList == null || linkedList.isEmtpy())
            throw new IllegalArgumentException("Provided linked list should not be null or empty");

        Node<T> currNode = linkedList.head;

        while (currNode!= null) {
            this.insertAtEnd(currNode.data);
            currNode = currNode.next;
        }
    }

    /**
     * Insert element at the start of the LinkedList.
     * <br>
     * Time complexity: O(1)
     * @param data data to be inserted
     */
    // case 1 -> 0 elements : create new node, set newNode to head and tail
    // case 2 -> 1 element : create new node, set head to newNode.next, set newNode to head's prev, set new node as head
    // case 3 -> >1 element : create new node, set head to newNode.next, set newNode to head's prev, set new node as head
    public void insertAtHead(T data){
        Node<T> newNode = new Node<>(null, data, this.head);

        if(isEmtpy()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            this.head = newNode;
        }

        this.size++;
    }

    /**
     * Insert element at the end of the LinkedList.
     * <br>
     * Time complexity: O(1)
     * @param data data to be inserted
     */
    // case 1 -> 0 elements : call insertAtHead
    // case 2 -> 1 element : create new node, set tail to newNode's prev, set newNode to tail.next, set newNode to tail
    // case 3 -> >1 element : create new node, set tail to newNode's prev, set newNode to tail.next, set newNode to tail
    public void insertAtEnd(T data) {
        if(isEmtpy()) {
            insertAtHead(data);
            return;
        }

        Node<T> newNode = new Node<>(this.tail, data, null);

        this.tail.next = newNode;
        this.tail = newNode;
    }

    public void insert(int index, T data) {
        if(index < 0 || index > this.size)
            throw new IndexOutOfBoundsException("Cannot insert element at Index: " + index + ", as the Size of Linked list is: " + this.size);

        if (index == 0) {
            insertAtHead(data);
        } else if (index == this.size()) {
            insertAtEnd(data);
        } else {
            //insertAtMiddle(index, data);
        }
    }

//    private void insertAtMiddle(int index, T data) {
//        Node<T> newNode = new Node<>(null, data, null);
//
//        if(index < (this.size >> 1 )){
//
//        }
//    }

    //delete methods

    //get

    //contains

    //clear

    // Empty
    public boolean isEmtpy() {
        return this.size == 0;
    }

    // size
    public int size(){
        return this.size;
    }

    // printLinkedList

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T data, Node<T> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
}
