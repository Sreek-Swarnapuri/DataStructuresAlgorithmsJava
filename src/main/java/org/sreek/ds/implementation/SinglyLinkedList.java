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
        if(linkedList == null || linkedList.isEmpty() )
            throw new IllegalArgumentException("Input linked list should not be null or empty");

        Node<T> currNode = linkedList.head;
        this.size = 0;
        while(currNode != null) {
            this.insertAtEnd(currNode.data);
            currNode = currNode.next;
        }

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
            throw new IndexOutOfBoundsException("Cannot insert element at Index: " + index + ", as the Size of Linked list is: " + this.size);

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
    public T delete(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Cannot delete element at Index : " + index + ", as the Size of Linked list is: " + this.size);

        if(index == 0)
            return deleteAtHead();
        else if (index == this.size - 1)
            return deleteAtEnd();
        else
            return deleteAtMiddle(index);
    }

    private T deleteAtMiddle(int index) {
        Node<T> currNode = this.head;

        for (int i = 0; i < index - 1 ; i++) {
            currNode = currNode.next;
        }
        Node<T> deletedNode = currNode.next;
        currNode.next = deletedNode.next;
        this.size--;

        deletedNode.next = null;

        return deletedNode.data;
    }

    public T get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Cannot retrieve element at Index: " + index + ", as the size of the Linked list is: " + this.size);
        else if(index == 0)
            return this.head.data;

        Node<T> currNode = this.head;

        for (int i = 0; i < index ; i++) {
            currNode = currNode.next;
        }

        return currNode.data;
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

    // cleanup Linked list
    public void clear() {
        Node<T> currNode = this.head;

        while (currNode!=null) {
            Node<T> nextNode = currNode.next;
            currNode.data = null;
            currNode.next = null;
            currNode = nextNode;
        }

        this.head = null;
        this.size = 0;
    }

    // check if the linked list contains the given data
    public boolean contains(T data) {
        if(isEmpty()) {
            System.out.println("Linked list is empty!");
            return false;
        }
        Node<T> currNode = this.head;

        while(currNode != null) {
            if(currNode.data.equals(data))
                return true;
            currNode = currNode.next;
        }

        return false;
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
