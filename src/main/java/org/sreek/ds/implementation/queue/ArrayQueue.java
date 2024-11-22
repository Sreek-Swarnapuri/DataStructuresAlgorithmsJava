package org.sreek.ds.implementation.queue;


import java.util.Arrays;

public class ArrayQueue<T> {

    private final T[] elements;
    private final int capacity;
    private int size;

    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    /**
     * Checks if the queue is empty
     * <br>
     * Time complexity: O(1)
     *
     * @return {@code true} if there are no elements in queue
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full or not
     * <br>
     * Time complexity: O(1)
     *
     * @return {@code true} if the queue is full
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Returns the current size of the queue
     * <br>
     * Time complexity: O(1)
     *
     * @return current size of queue
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns the top element in the queue. Returns {@code null} if the queue is empty.
     * <br>
     * Time complexity: O(1)
     *
     * @return top element in the queue
     */
    public T top() {
        if (isEmpty())
            return null;

        return this.elements[this.front];
    }


    /**
     * Adds the given element at the end of the queue. Does nothing if the queue is full
     * <br>
     * Time complexity: O(1)
     *
     * @param data to be added at the end of the queue
     */
    public void enqueue(T data) {
        if (isFull())
            throw new ArrayIndexOutOfBoundsException("Queue is full");

        this.rear = (this.rear + 1) % this.capacity;
        this.elements[this.rear] = data;
        this.size++;
    }

    /**
     * Removes the first element in the Queue and returns it. Returns {@code null} if queue is empty.
     * <br>
     * Time complexity: O(1)
     */
    public T dequeue() {
        if (isEmpty())
            return null;

        T deleted = this.elements[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return deleted;
    }

    /**
     * Clears any data present in the Queue and resets size to 0
     * <br>
     * Time complexity: O(n)
     */
    public void clear() {
        for (int i = 0; i < this.capacity; i++) {
            elements[i] = null;
        }
        this.size = 0;
        this.front = 0;
        this.rear = -1;

    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "elements=" + Arrays.toString(elements) +
                ", capacity=" + capacity +
                ", size=" + size +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }
}
