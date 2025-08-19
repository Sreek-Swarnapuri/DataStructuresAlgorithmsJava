package org.sreek.ds.implementation.graph.tree.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap<T extends Comparable<T>> {

    /*
    private T[] heap;           // Generic array to hold heap elements
    private int size;           // Current number of elements in the Heap array
    private int capacity;       // Total capacity of the Heap, can be increated when the capacity limit is reached.
    private final boolean isMinHeap;  // True for MinHeap, false for MaxHeap

    private static final int DEFAULT_CAPACITY = 10;


    private Heap(boolean isMinHeap) {
        this.capacity = DEFAULT_CAPACITY;
        this.heap = (T[]) new Comparable[capacity]; // Java doesn't allow generic array creation directly
        this.size = 0;
        this.isMinHeap = isMinHeap;
    }

    public void insert(T value) {
        if(size == capacity) {
            resize(); // Dynamically grow the array
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while(index > 0 && compare(heap[index], heap[parentIndex])) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public T peek() {
        return this.heap[0];
    }

    public T poll() {
        return null;
    }

    public void heapify(T[] arr) {
        return;
    }

//    public void printHeapPretty() {
//        int maxLevel = (int) (Math.log(this.size) / Math.log(2)) + 1;
//        int index = 0;
//
//        for (int level = 0; level < maxLevel; level++) {
//            int itemsInLevel = (int) Math.pow(2, level);
//            int spacing = (int) Math.pow(2, maxLevel - level);
//
//            for (int i = 0; i < itemsInLevel && index < this.size; i++) {
//                System.out.print(" ".repeat(spacing) + heap[index++] + " ");
//            }
//            System.out.println();
//        }
//    }


    public static void main(String[] args) {
        Heap<Integer> minHeap = new Heap<>(true);

        for (int i = 1; i <= 15; i ++) {
            minHeap.insert(i);
        }

        //minHeap.printHeapPretty();

    }


    //===========================================HELPER METHODS BELOW=========================================================

    private void resize() {
        this.capacity *= 2;
        T[] newHeap = (T[]) new Comparable[capacity];
        System.arraycopy(this.heap, 0, newHeap,0, size);
        heap = newHeap;
    }

    private boolean compare(T child, T parent) {
        return isMinHeap ? child.compareTo(parent) < 0 : child.compareTo(parent) > 0;
    }

    private void swap(int i, int j) {
        T temp = heap[j];
        heap[j] = heap[i];
        heap[i] = temp;
    }

    private static int heightOfHeap(int n) {
        return (int) ( Math.log(n) / Math.log(2) );
    }
     */


    private static final int DEFAULT_CAPACITY = 10;

    private T[] elements;
    private int size;
    private int capacity;
    private boolean isMinHeap;

    @SuppressWarnings("unchecked")
    public Heap(Class<T> clazz) {
        this.capacity = DEFAULT_CAPACITY;
        this.elements = (T[]) Array.newInstance(clazz, capacity);
    }

    @SuppressWarnings("unchecked")
    public Heap(Class<T> clazz, int capacity) {
        this.capacity = capacity;
        this.elements = (T[]) Array.newInstance(clazz, capacity);
    }

    public void insert(T element) {
        if(this.size == this.capacity)
            grow();

        this.elements[this.size++] = element;

        heapifyUp(this.size - 1);
    }

    public T pop() {

        T root = this.elements[0];
        this.elements[0] = this.elements[this.size  - 1];
        this.elements[this.size - 1] = null;
        this.size--;

        heapifyDown(0);

        return root;
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
