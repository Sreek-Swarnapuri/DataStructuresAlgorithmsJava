package org.sreek.ds.implementation;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public SinglyLinkedList(T data) {
        Node<T> n = new Node<>(data, null);
        this.size = 1;
        this.head = n;
    }

    public SinglyLinkedList(SinglyLinkedList<T> linkedList) {
        this.head = linkedList.head;
        this.size = linkedList.size;
    }

    // getSize
    public int getSize() {
        return size;
    }

    /**
     *  returns true if the SinglyLinkedList is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return  size == 0;
    }

    // insert at head
    public void insertAtHead(T data) {
        Node<T> newNode = new Node<>(data, null);

        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    // insert at index
    public void insert(int index, T data) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);

        if (index == 0) {
            insertAtHead(data);
        } else if (index == size) {
            insertAtEnd(data);
        } else {
            insertAtMiddle(index, data);
        }
    }

    private void insertAtMiddle(int index, T data) {
        Node<T> newNode = new Node<>(data, null);
        Node<T> currNode = this.head;
        Node<T> prevNode = null;
        for (int i = 0; i <= index; i++) {
            if(i == index)
                prevNode = currNode;
            currNode = currNode.next;
        }
        newNode.next = currNode;
        prevNode.next = newNode;
        this.size++;
    }

    // insert at end
    public void insertAtEnd(T data){

        if(isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node<T> newNode = new Node<>(data, null);
        Node<T> currentNode = head;

        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        this.size++;
    }

    // delete at head
    // delete at index
    // delete at end

    public void printLinkedList() {
        if(this.size == 0) {
            System.out.println("Empty Linked List!!");
            return;
        }

        System.out.println("Size of the Linked List: " + this.size);
        System.out.println("Printing the Linked List: ");
        Node<T> currNode = this.head;
        int i = 0;
        while (currNode != null) {
            System.out.print(i++ + ": [" + currNode.data + "]");
            currNode = currNode.next;
            if (currNode!=null)
                System.out.print(" -> ");
            else
                System.out.print(" -> NULL");
        }
        System.out.println();
    }

    private static class Node<T> {
         T data;
         Node<T> next;

         Node(T data, Node<T> next) {
             this.data = data;
             this.next = next;
         }
    }
}
