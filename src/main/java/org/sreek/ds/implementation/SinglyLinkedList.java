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

        for (int i = 0; i < index - 1; i++) {
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
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
    public T deleteAtHead() {
        if(isEmpty()){
            System.out.println("Linked List is empty!");
            return null;
        }

        Node<T> headNode = this.head;

        this.head = this.head.next;
        this.size--;

        return headNode.data;
    }

    // delete at end
    public T deleteAtEnd() {
        if(isEmpty()){
            System.out.println("Linked List is empty!");
            return null;
        }

        if(this.size == 1) {
            return deleteAtHead();
        }

        Node<T> currentNode = this.head;

        while(currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        Node<T> deletedNode = currentNode.next;
        currentNode.next = null;

        this.size--;

        return deletedNode.data;
    }

    // delete at index
    public T delete(int index, T data) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index given: " + index + " Size: " + this.size);

        if(index == 0)
            return deleteAtHead();
        else if (index == this.size)
            return deleteAtEnd();
        else
            return deleteAtMiddle(index, data);
    }

    private T deleteAtMiddle(int index, T data) {
        Node<T> currNode = this.head;

        for (int i = 0; i < index ; i++) {
            currNode = currNode.next;
        }
        Node<T> deletedNode = currNode.next;
        currNode.next = deletedNode.next;
        this.size--;

        deletedNode.next = null;

        return deletedNode.data;
    }



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
