package org.sreek.ds.usage.builtin;

import java.sql.Time;
import java.util.*;

public class Stacks {

    public static void main(String[] args) {

        System.out.println("------ Using legacy Stack itself -----");

        // Start time in milliseconds
        long startTime = System.currentTimeMillis();
        System.out.println("Start Time: " + startTime + " ms");

        // Takes around 7 to 8 ms
        stackVectorUsage();

        // End time in milliseconds
        long endTime = System.currentTimeMillis();
        System.out.println("End Time: " + endTime + " ms");

        // Total execution time
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");


        System.out.println("------ Using Linked List as Stack -----");

        // Start time in milliseconds
        startTime = System.currentTimeMillis();
        System.out.println("Start Time: " + startTime + " ms");

        // Also Takes around 0 to 1 ms
        linkedListAsStack();

        // End time in milliseconds
        endTime = System.currentTimeMillis();
        System.out.println("End Time: " + endTime + " ms");

        // Total execution time
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");


        System.out.println("------ Using Array Deque as Stack -----");

        // Start time in milliseconds
        startTime = System.currentTimeMillis();
        System.out.println("Start Time: " + startTime + " ms");

        // Takes around 0 to 1 ms
        arrayDequeAsStack();

        // End time in milliseconds
        endTime = System.currentTimeMillis();
        System.out.println("End Time: " + endTime + " ms");

        // Total execution time
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");

    }

    /**
     * The Stack class in java.util is the traditional stack implementation in Java, extending Vector.
     * It follows the LIFO (Last In, First Out) principle and provides standard stack operations like push, pop, peek, empty, and search.
     * <p>
     * Notes: Stack is synchronized, which makes it thread-safe but slightly slower in single-threaded contexts.
     * It’s generally considered a legacy class and isn’t commonly used in modern code.
     */
    public static void stackVectorUsage() {
        Stack<Integer> iStack = new Stack<>();

        iStack.push(1);
        iStack.push(2);
        System.out.println("Peeking the stack: " + iStack.peek());
        System.out.println("Printing stack: " + iStack);
        iStack.push(3);
        iStack.push(4);
        System.out.println("Peeking the stack: " + iStack.peek());
        System.out.println("Printing stack: " + iStack);

        iStack.push(3);
        iStack.push(43);
        System.out.println("Popping an element from the stack: " + iStack.pop());
        System.out.println("Peeking the stack: " + iStack.peek());
        System.out.println("Printing stack: " + iStack);

    }

    /**
     * ArrayDeque is a more recent implementation of a stack in Java.
     * It’s a double-ended queue but can be used as a stack when restricted to push, pop, and peek methods.
     * <p>
     * Notes: ArrayDeque is not synchronized, so it is faster in single-threaded contexts than Stack.
     * It is generally preferred over Stack for stack-like operations.
     */
    public static void arrayDequeAsStack() {
        Deque<Integer> iStack = new ArrayDeque<>();

        iStack.push(1);
        iStack.push(2);
        System.out.println("Peeking the stack: " + iStack.peek());
        System.out.println("Printing stack: " + iStack);
        iStack.push(3);
        iStack.push(4);
        System.out.println("Peeking the stack: " + iStack.peek());
        System.out.println("Printing stack: " + iStack);

        iStack.push(3);
        iStack.push(43);
        System.out.println("Popping an element from the stack: " + iStack.pop());
        System.out.println("Peeking the stack: " + iStack.peek());
        System.out.println("Printing stack: " + iStack);
    }

    /**
     * LinkedList is a doubly linked list implementation that can also function as a stack.
     * It supports push, pop, and peek operations when treated as a stack.
     * <p>
     * Notes:
     * LinkedList is also not synchronized and is suitable for both stack and queue operations.
     * However, ArrayDeque is generally faster in practice when used as a stack due to better cache locality.
     */
    public static void linkedListAsStack() {
        LinkedList<Integer> iStack = new LinkedList<>();

        iStack.push(1);
        iStack.push(2);
        System.out.println("Peeking the stack: " + iStack.peek());
        System.out.println("Printing stack: " + iStack);
        iStack.push(3);
        iStack.push(4);
        System.out.println("Peeking the stack: " + iStack.peek());
        System.out.println("Printing stack: " + iStack);

        iStack.push(3);
        iStack.push(43);
        System.out.println("Popping an element from the stack: " + iStack.pop());
        System.out.println("Peeking the stack: " + iStack.peek());
        System.out.println("Printing stack: " + iStack);
    }



}
