package org.sreek.ds.usage.impl.queue;

import org.sreek.ds.implementation.queue.ArrayQueue;

public class ArrayQueueImplUsage {

    public static void main(String[] args) {
        ArrayQueue<Character> charQueue = new ArrayQueue<>(5);

        charQueue.enqueue('a');
        charQueue.enqueue('e');
        charQueue.enqueue('i');
        charQueue.enqueue('o');
        charQueue.enqueue('u');

        System.out.println(charQueue);
        try {
            charQueue.enqueue('x');
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Queue is full");
            e.printStackTrace();
        }

        char d = charQueue.dequeue();
        System.out.println("Removed following char from queue: " + d);
        System.out.println(charQueue);

        charQueue.enqueue('x');
        System.out.println("Added 'x' to the queue - " + charQueue);

        System.out.println("Top of the queue is : " + charQueue.top());
        System.out.println("Is the queue full : " + charQueue.top());
        System.out.println("Is the queue empty : " + charQueue.top());
        System.out.println("Size of the queue is : " + charQueue.size());

        d = charQueue.dequeue();
        System.out.println("Removed following char from queue: " + d);
        d = charQueue.dequeue();
        System.out.println("Removed following char from queue: " + d);
        d = charQueue.dequeue();
        System.out.println("Removed following char from queue: " + d);
        d = charQueue.dequeue();
        System.out.println("Removed following char from queue: " + d);
        d = charQueue.dequeue();
        System.out.println("Removed following char from queue: " + d);
        try {
            d = charQueue.dequeue();
            System.out.println("Removed following char from queue: " + d);
        } catch (NullPointerException e) {
            System.out.println("Queue is empty!");
            e.printStackTrace();
        }

        charQueue.clear();
        System.out.println(charQueue);
        System.out.println("Is the queue empty? " + charQueue.isEmpty());

    }

}
