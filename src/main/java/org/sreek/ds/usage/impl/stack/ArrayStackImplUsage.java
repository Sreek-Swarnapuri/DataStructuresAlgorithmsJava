package org.sreek.ds.usage.impl.stack;

import org.sreek.ds.implementation.stack.ArrayStack;

public class ArrayStackImplUsage {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(4);

        System.out.println(stack);
        stack.push(1);
        System.out.println("Pushing 1 to stack");
        System.out.println("Stack's top element is " + stack.peek());
        System.out.println(stack);
        stack.push(2);
        System.out.println("Pushing 2 to stack");
        System.out.println("Stack's top element is " + stack.peek());
        System.out.println(stack);
        stack.push(3);
        System.out.println("Pushing 3 to stack");
        System.out.println("Stack's top element is " + stack.peek());
        System.out.println(stack);
        stack.push(4);
        System.out.println("Pushing 4 to stack");
        System.out.println("Stack's top element is " + stack.peek());
        System.out.println(stack);

        try {
            System.out.println("Trying to push an element on top of an already full stack: ");
            stack.push(5);
        } catch (StackOverflowError e) {
            System.out.println("Stack is already full");
            e.printStackTrace();
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("Popping stack, top element is: " + stack.pop());
            System.out.println(stack);
        }

        System.out.println("Popping stack, top element is: " + stack.pop());

    }

}
