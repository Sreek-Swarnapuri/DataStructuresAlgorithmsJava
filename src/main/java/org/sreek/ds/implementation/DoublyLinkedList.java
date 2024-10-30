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
        if(linkedList == null || linkedList.isEmpty())
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

        if(isEmpty()) {
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
        if(isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node<T> newNode = new Node<>(this.tail, data, null);

        this.tail.next = newNode;
        this.tail = newNode;
        this.size++;
    }

    /**
     * Inserts a new element with the data provided at the given index.
     *      index:0 -> inserts at head,
     *      index: size > inserts at end,
     *      otherwise inserts at middle
     * <br>
     * Time complexity: O(n)
     * @param index - index at which data should be inserted
     * @param data = data to be inserted
     */
    public void insert(int index, T data) {
        if(index < 0 || index > this.size)
            throw new IndexOutOfBoundsException("Cannot insert element at Index: " + index + ", as the Size of Linked list is: " + this.size);

        if (index == 0) {
            insertAtHead(data);
        } else if (index == this.size()) {
            insertAtEnd(data);
        } else {
            insertAtMiddle(index, data);
        }
    }

    /**
     * Internal method to insert at middle. Traverses from head or tail based on the index position from middle.
     * <br>
     * Time complexity: O(n)
     * @param index - index at which data should be inserted
     * @param data = data to be inserted
     */
    private void insertAtMiddle(int index, T data) {

        Node<T> currNode = getNode(index);

        Node<T> newNode = new Node<>(currNode.prev, data, currNode);
        currNode.prev.next = newNode;
        currNode.prev = newNode;
        this.size++;
    }

    /**
     * Retrieve the element/Node at the given index
     * <br>
     * Time complexity: O(n/2) -> O(n)
     * @param index index at which node is to be retrieved
     * @return Node<T>
     */
    private Node<T> getNode(int index) {
        Node<T> currNode;
        if(index < (this.size >> 1)){
            currNode = this.head;
            for(int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
        } else {
            currNode = this.tail;
            for(int i = this.size - 1; i > index; i--) {
                currNode = currNode.prev;
            }
        }
        return currNode;
    }

    /**
     * Deletes the element at head
     * <br>
     * Time complexity: O(1)
     * @return deleted element's data
     */
    public T deleteAtHead() {
        if(isEmpty()) {
            System.out.println("Linked List is empty");
            return null;
        }
        Node<T> deleteNode = this.head;

        if(this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head.next.prev = null;
            this.head = this.head.next;
        }

        deleteNode.next = null;
        this.size--;
        return deleteNode.data;
    }

    /**
     * Deletes the element/node at the end
     * <br>
     * Time complexity: O(1)
     * @return deleted element/node's data
     */
    public T deleteAtEnd() {
        if(this.size <= 1)
            return deleteAtHead();

        Node<T> deleteNode = this.tail;

        this.tail.prev.next = null;
        this.tail = this.tail.prev;
        deleteNode.prev = null;
        this.size--;

        return deleteNode.data;
    }

    /**
     * Deletes the element/node at the given index.
     *      delete:0 -> deletes at head,
     *      delete: size > deletes at end,
     *      otherwise delete at middle
     * Throws IndexOutOfBoundsException if the given index is out of range 0 to size of LinkedList.
     * <br>
     * Time complexity: O(n)
     * @param index index of the element to be deleted.
     * @return data that is deleted
     */
    public T delete(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Cannot delete element at Index : " + index + ", as the Size of Linked list is: " + this.size);

        if(index == 0) {
            return deleteAtHead();
        } else if (index == this.size - 1) {
            return deleteAtEnd();
        } else {
            return deleteFromMiddle(index);
        }

    }

    private T deleteFromMiddle(int index) {
        Node<T> deleteNode = getNode(index);

        deleteNode.prev.next = deleteNode.next;
        deleteNode.next.prev = deleteNode.prev;

        deleteNode.prev = null;
        deleteNode.next = null;

        this.size--;
        return deleteNode.data;
    }

    /**
     * Retrieves the data present at the given index of the Linked List.
     * <br>
     * Time Complexity: O(n)
     * @param index index of the element needed.
     * @return T
     */
    public T get(int index) {
        if(isEmpty()) {
            System.out.println("Linked List is empty");
            return null;
        }

        if(index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("Cannot retrieve value of element at Index: " + index + ", as the Size of Linked list is: " + this.size);

        Node<T> node = getNode(index);

        return node.data;
    }

    /**
     * Checks if the provided data is present in the Linked List.
     * <br>
     * Time complexity: O(n)
     * @param data data which is to be checked
     * @return boolean
     */
    public boolean contains(T data){
        if(isEmpty()) {
            System.out.println("Linked List is empty");
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

    /**
     * Clears the linked list and resets it as a new LinkedList
     * <br>
     * Time Complexity: O(n)
     */
    public void clear() {
        if(isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }
        Node<T> currNode = this.head;
        while(currNode!= null) {
            Node<T> nextNode = currNode.next;
            currNode.prev = null;
            currNode.data = null;
            currNode.next = null;
            currNode = nextNode;
        }

        this.head = this.tail = null;
        this.size = 0;
    }

    /**
     * Checks if the Linked list is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the size of the Linked List
     * @return int
     */
    public int size(){
        return this.size;
    }

    // printLinkedList
    public void print() {
        Node<T> currNode = this.head;
        int i = 0;
        System.out.println("-----------Printing Linked List-----------");
        System.out.println("Size of the linked list is " + this.size);
        while (currNode != null) {
            if(currNode.prev == null) {
                System.out.print("NULL <- ");
            }
            System.out.print( "{ " + i + ": [" + currNode.data + "] }");

            if(currNode.next == null)
                System.out.print(" -> NULL");
            else
                System.out.print(" <-> ");

            currNode = currNode.next;
            i++;
        }
        System.out.println("\n");
    }

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
