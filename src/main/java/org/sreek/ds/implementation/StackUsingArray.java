package org.sreek.ds.implementation;

public class StackUsingArray<T> {

    private int size;
    private int top;
    private Object[] elements;

    public StackUsingArray(int size){
        this.size = size;
        this.top = -1;
        elements = new Object[size];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return ( this.size - 1 ) == this.top;
    }

    public void push(T data) {
        if( isFull() ) {
            throw new StackOverflowError("Stack is full");
        }
        this.elements[++top] = data;
        this.size++;   
    }


}
