package org.sreek.ds.implementation.stack;

import java.util.EmptyStackException;

public class LinkedListStack<T> {

    private Node top; // tail is top of stack
    private int size;

    public LinkedListStack() {
        this.top = null;
    }

    public LinkedListStack(T data) {
        this();
        push(data);
    }

    /**
     * Checks if the Stack is empty
     * <br>
     * Time complexity: O(1)
     *
     * @return {@code true} if the stack is empty
     */
    public boolean isEmpty() {
        return this.top == null;
    }

    /**
     * Size of the Stack
     * <br>
     * Time complexity: O(1)
     *
     * @return the size of the stack
     */
    public int size() {
        return this.size;
    }

    /**
     * Pushes element on top of the stack
     * <br>
     * Time complexity: O(1)
     *
     * @param data of the element to be pushed
     */
    public void push(T data) {
        if (data == null)
            throw new IllegalArgumentException("data should not be null");

        this.top = new Node(this.top, data);
        this.size++;

    }

    /**
     * Pops the element from the top of the stack
     * <br>
     * Time complexity: O(1)
     *
     * @return the element that is popped
     */
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        Node deletedNode = this.top;

        this.top = this.top.prev;
        this.size--;

        deletedNode.prev = null;

        return deletedNode.data;
    }

    /**
     * Gives the element on top of the stack but does not remove it.
     * <br>
     * Time complexity: O(1)
     *
     * @return the element on top of the stack
     */
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return this.top.data;
    }

    @Override
    public String toString() {

        if (isEmpty())
            return "Empty Stack";

        StringBuilder sb = new StringBuilder();


        sb.append("Stack is as follows: \n");
        sb.append("Stack size : ").append(this.size).append("\n");

        Node currNode = this.top;

        for (int i = this.size - 1; i > -1; i--) {
            sb.append(i).append(" : ").append(currNode.data);
            if (currNode == this.top)
                sb.append("  <--  top");
            sb.append("\n");

            currNode = currNode.prev;
        }

        return sb.toString();
    }

    private class Node {
        Node prev;
        T data;

        Node(Node prev, T data) {
            this.prev = prev;
            this.data = data;
        }
    }
}
