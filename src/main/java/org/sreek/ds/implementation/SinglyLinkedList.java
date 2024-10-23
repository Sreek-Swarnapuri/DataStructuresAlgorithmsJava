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
        Node<T> n = new Node<>(data, null);

        n.next = this.head;
        this.head = n;
        this.size++;
    }

    // insert at index
    // insert at end
    public void insertAtEnd(T data){

        if(isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node<T> n = new Node<>(data, null);

        Node<T> cn = head;

        while(cn.next != null) {
            cn = cn.next;
        }

        cn.next = n;
    }

    // delete at head
    // delete at index
    // delete at end


    private static class Node<T> {
         T data;
         Node<T> next;

         Node(T data, Node<T> next) {
             this.data = data;
             this.next = next;
         }
    }
}
