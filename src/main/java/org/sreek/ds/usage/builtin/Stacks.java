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

        System.out.println("Pushing 10000000 elements into stack");
        for (int i = 0; i < 10000000; i++) {
            iStack.push(i);
        }

        System.out.println("Popping 4872000 elements:");
        HashSet<Integer> peekingNumbers = getIntegers();

        for (int i = 0; i < 4872000; i++) {
            iStack.pop();
            if(peekingNumbers.contains(i))
                System.out.println("Peeking top of the stack: " + i);
        }
        System.out.println("Size of the stack: " + iStack.size());


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

        System.out.println("Pushing 10000000 elements into stack");
        for (int i = 0; i < 10000000; i++) {
            iStack.push(i);
        }

        System.out.println("Popping 4872000 elements:");
        HashSet<Integer> peekingNumbers = getIntegers();

        for (int i = 0; i < 4872000; i++) {
            iStack.pop();
            if(peekingNumbers.contains(i))
                System.out.println("Peeking top of the stack: " + i);
        }
        System.out.println("Size of the stack: " + iStack.size());
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

        System.out.println("Pushing 10000000 elements into stack");
        for (int i = 0; i < 10000000; i++) {
            iStack.push(i);
        }

        System.out.println("Popping 4872000 elements:");
        HashSet<Integer> peekingNumbers = getIntegers();

        for (int i = 0; i < 4872000; i++) {
            iStack.pop();
            if(peekingNumbers.contains(i))
                System.out.println("Peeking top of the stack: " + i);
        }
        System.out.println("Size of the stack: " + iStack.size());
    }

    private static HashSet<Integer> getIntegers() {
        HashSet<Integer> nums = new HashSet<>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(333);
        nums.add(765);
        nums.add(1243);
        nums.add(43);
        nums.add(10);
        nums.add(30);
        nums.add(50);
        nums.add(3336);
        nums.add(76566);
        nums.add(12463);
        nums.add(463);
        nums.add(189657);
        nums.add(4563);
        nums.add(5456);
        nums.add(3456433);
        nums.add(745665);
        nums.add(1245643);
        nums.add(43456);
        nums.add(45610);
        nums.add(34560);
        nums.add(56450);
        nums.add(3456336);
        nums.add(76456566);
        nums.add(14562463);
        nums.add(446563);
        return nums;
    }

}
