package org.sreek.ds.implementation.graph.tree.heap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>> {

    private static final Logger logger = LogManager.getLogger(Heap.class);

    private static final int DEFAULT_CAPACITY = 10;

    private T[] elements;
    private int size;
    private int capacity;
    private final boolean isMinHeap;

    public boolean isMinHeap() {
        return isMinHeap;
    }

    @SuppressWarnings("unchecked")
    public Heap(Class<T> clazz, boolean isMinHeap) {
        this.capacity = DEFAULT_CAPACITY;
        this.isMinHeap = isMinHeap;
        this.elements = (T[]) Array.newInstance(clazz, capacity);
    }

    @SuppressWarnings("unchecked")
    public Heap(Class<T> clazz, boolean isMinHeap, int capacity) {
        this.capacity = capacity;
        this.isMinHeap = isMinHeap;
        this.elements = (T[]) Array.newInstance(clazz, capacity);
    }

    public void push(T element) {
        if(this.size == this.capacity)
            grow();

        this.elements[this.size++] = element;

        heapifyUp(this.size - 1);
    }

    public T pop() {

        if(this.size == 0)
            throw new IllegalStateException("Heap is empty!");

        T root = this.elements[0];
        this.elements[0] = this.elements[this.size  - 1];
        this.elements[this.size - 1] = null;
        this.size--;

        heapifyDown(0);

        return root;
    }

    public void buildHeapFromArray(T[] elements) {
        // clear the heap
        this.clearHeap();

        // Add the new elements to the heap Array
        for (T element: elements) {
            if(this.size == this.capacity)
                this.grow();
            this.elements[this.size++] = element;
        }

        // loop through from bottom non-leaf node to root and perform heapifyDown
        for (int i = (this.size / 2) - 1; i >= 0 ; i--) {
            heapifyDown(i);
        }
    }

    public void delete(T element) {

        if (this.size == 0)
            throw new IllegalStateException("Heap is empty!");

        int elementIndex = -1;

        // Find the index of the element to be deleted
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                elementIndex = i;
                break;
            }
        }

        // if the element is not found throw error
        if (elementIndex == -1)
            throw new NoSuchElementException("Cannot find element - " + element);

        // if the element is found, swap it with last element from elements array and heapifyUp/heapifyDown
        // at the index as it could violate the heap property
        if (elementIndex != (this.size - 1))
            this.swap(elementIndex, (this.size - 1));

        this.elements[this.size - 1] = null;
        this.size--;

        // if we deleted the last element, no heapify required
        if (elementIndex >= this.size )
            return;

        // Check if the heap property is violated
        int parentIndex = (elementIndex - 1 ) / 2;
        if(parentIndex >= 0 && compare(elementIndex, parentIndex)) {
            heapifyUp(elementIndex);
        } else {
            heapifyDown(elementIndex);
        }
    }

    public void printHeapArray() {
        StringBuilder sb = new StringBuilder(this.size * 2);
        for (int i = 0; i < this.size; i++) {
            sb.append(this.elements[i]).append(" ");
        }

        logger.info("Heap Size: {}, Heap Array: {}", this.size, sb.toString());
    }

    public void clearHeap() {
        Arrays.fill(this.elements, 0, size, null);
        this.size = 0;
    }

    private void heapifyUp(int index) {

        int parentIndex = (index - 1) / 2;

        if(index > 0 && compare(index, parentIndex)) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }

    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int targetIndex = index;

        if(leftChildIndex < this.size && compare(leftChildIndex, targetIndex))
            targetIndex = leftChildIndex;
        if(rightChildIndex < this.size && compare(rightChildIndex, targetIndex))
            targetIndex = rightChildIndex;

        if(targetIndex != index) {
            swap(targetIndex, index);
            heapifyDown(targetIndex);
        }
    }



    // --------------------- Helper methods --------------------

    private boolean compare(int i, int j) {
        return this.isMinHeap ? (this.elements[i].compareTo(this.elements[j])) < 0 : (this.elements[i].compareTo(this.elements[j])) > 0;
    }

    private void swap(int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private void grow() {
        this.capacity *= 2;
        this.elements = Arrays.copyOf(elements, this.capacity);
    }

}
