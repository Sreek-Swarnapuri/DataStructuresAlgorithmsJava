package org.sreek.ds.implementation;

import java.util.EmptyStackException;

public class ArrayStack<T> {

    private final int capacity;
    private int top;
    private final T[] elements;

    @SuppressWarnings("unchecked") // as we are maintaining a strict type and control the creation of the array only in this class
    public ArrayStack(int size){
        this.capacity = size;
        this.top = -1;
        elements = (T[]) new Object[size];
    }

    /**
     * Checks if the stack is empty
     * @return {@code true} if there are no elements in Stack
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * Checks if the stack is full
     * @return {@code true} if the stack has elements up to provided capacity
     */
    public boolean isFull() {
        return ( this.capacity - 1 ) == this.top;
    }

    /**
     * Adds provided data on top of the stack.
     * @param data data to be pushed onto the stack
     */
    public void push(T data) {
        if( isFull() ) {
            throw new StackOverflowError("Stack is full");
        }
        this.elements[++top] = data;
    }


    /**
     * Removes the top element of the stack
     * @return top element of the stack
     */
    public T pop() {
        if( isEmpty() )
            throw new EmptyStackException();
        T popElement = this.elements[top--];
        this.elements[top+1] = null; // Avoid memory leak

        return popElement;
    }

    /**
     * Shows the top element of the stack
     * @return the data on top of the stack
     */
    public T peek() {
        if( isEmpty() )
            throw new EmptyStackException();

        return this.elements[top];
    }

    @Override
    public String toString() {
        if(isEmpty()) return "Stack is empty!";

        StringBuilder sb = new StringBuilder();

        sb.append("Stack capacity : ").append(capacity).append("\n");
        sb.append("Stack is as follows: \n");

        for (int i = top; i > -1; i--) {
            sb.append(i).append(" : ").append(this.elements[i]);
            if(i == this.top)
                sb.append("  <--  top");
            sb.append("\n");
        }

        return sb.toString();
    }
}
