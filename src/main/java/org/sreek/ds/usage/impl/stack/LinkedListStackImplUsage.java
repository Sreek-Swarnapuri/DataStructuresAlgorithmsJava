package org.sreek.ds.usage.impl.stack;

import org.sreek.ds.implementation.stack.LinkedListStack;

import java.util.EmptyStackException;

public class LinkedListStackImplUsage {

    public static void main(String[] args) {
        LinkedListStack<Integer> intStack = new LinkedListStack<>(1);
        System.out.println(intStack);
        System.out.println("Size of the Stack: " + intStack.size());
        intStack.push(2);
        System.out.println(intStack);
        intStack.push(3);
        intStack.push(4);
        System.out.println("Size of the Stack: " + intStack.size());
        intStack.push(5);
        intStack.push(6);
        System.out.println(intStack);
        System.out.println("popping stack: " + intStack.pop());
        System.out.println(intStack);
        intStack.push(7);
        System.out.println(intStack);

        System.out.println("popping stack: " + intStack.pop());
        System.out.println("popping stack: " + intStack.pop());

        System.out.println("Top of the stack: " + intStack.peek());
        System.out.println("Size of the Stack: " + intStack.size());
        System.out.println(intStack);

        try {
            intStack.push(null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            intStack.pop();
            intStack.pop();
            intStack.pop();
            intStack.pop();
            intStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty");
            e.printStackTrace();
        }

    }

}
