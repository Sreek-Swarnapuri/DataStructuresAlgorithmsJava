package org.sreek.ds.implementation.queue;

public class LinkedListQueue<T> {

    Node<T> front;
    Node<T> rear;
    int size;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public LinkedListQueue(T data) {
        this.rear = this.front = new Node<>(data, null);
        this.size = 1;
    }

    /**
     * Returns {@code true} if the queue is empty.
     * <br>
     * Time complexity: O(1)
     * @return boolean stating if the queue is empty or not
     */
    public boolean isEmpty() {
        return this.front == null;
    }

    /**
     * Gives the size of the queue.
     * <br>
     * Time complexity: O(1)
     * @return size of queue
     */
    public int size() {
        return this.size;
    }

    /**\
     * Returns the top element of the queue.
     * <br>
     * Time complexity: O(1)
     * @return top element of the queue.
     */
    public T top() {
        if(isEmpty())
            return null;
        return this.front.data;
    }

    /**
     * Adds an element to the queue. Throws IllegalArgumentException if provided data is null.
     * <br>
     * Time complexity: O(1)
     * @param data to be added at the end of the queue
     */
    public void enqueue(T data) {
        if(data == null)
            throw new IllegalArgumentException("Provided data should not be empty!");

        Node<T> newNode = new Node<>(data, null);

        if(isEmpty())
            this.front = this.rear = newNode;
        else
            this.rear = this.rear.next = newNode;

        this.size++;
    }

    /**
     * Removes the first element of the queue and returns it.
     * <br>
     * Time complexity: O(1)
     * @return data of the element removed from queue, {@code null} if the queue is empty.
     */
    public T dequeue() {
        if(isEmpty())
            return null;

        Node<T> deletedNode = this.front;

        this.front = this.front.next;
        if(this.size == 1)
            this.rear = this.rear.next;

        this.size--;

        return deletedNode.data;
    }

    /**
     * Clears the queue by removing all elements
     * <br>
     * Time complexity: O(n)
     */
    public void clear() {
        if (isEmpty())
            System.out.println("Queue is Empty!");
        while(this.front != null)
            System.out.println("Removing element: " + this.dequeue());
    }

    @Override
    public String toString() {

        if(isEmpty())
            return "Queue is empty!";

        StringBuilder sb = new StringBuilder();

        Node<T> currNode = this.front;

        for (int i = 0; i < this.size; i++) {
            sb.append("[ ").append(currNode.data).append(" ]");
            if(i != (this.size-1))
                sb.append(" --> ");
            currNode = currNode.next;
        }

        sb.append(" ; Size of Queue: ").append(this.size);

        return sb.toString();
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
