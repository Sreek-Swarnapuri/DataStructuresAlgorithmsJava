package org.sreek.ds.implementation.queue;


public class ArrayQueue<T> {

    private T[] elements;
    private int capacity;
    private int size;

    private int front;
    private int rear;

    public ArrayQueue(int size) {
        this.elements = (T[]) new Object[this.size];
        this.capacity = size;
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    // isFull
    public boolean isFull() {
        return size == capacity;
    }

    // top
    public T top() {
        if(isEmpty())
            return null;

        return this.elements[this.front];
    }


    // enqueue
    public void enqueue(T data) {
        if(isFull())
            return;

        this.rear = ( this.rear + 1 ) % this.capacity;
        this.elements[this.rear] = data;
        this.size++;
    }

    // dequeue
    public T dequeue() {
        if(isEmpty())
            return null;

        T deleted = this.elements[this.front];
        this.front = (this.front - 1) % this.capacity;
        this.size--;
        return  deleted;
    }

    // clear

}
