package org.sreek.ds.usage.builtin;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Queues {

    public static void main(String[] args) {

        Queue<Integer> integerQueue = new LinkedList<>();

        System.out.println("Queues using linked lists");
        performQueueOperations(integerQueue, 10000000);
        performQueueOperations(integerQueue, 100000000);

        integerQueue = new ArrayDeque<>();
        System.out.println("Queues using ArrayDeque");
        performQueueOperations(integerQueue, 10000000);
        performQueueOperations(integerQueue, 100000000);

    }


    public static void performQueueOperations(Queue<Integer> queue, int maxElementsToInsert) {

        System.out.println("===================================== START =====================================");

        // Start time in milliseconds
        long startTime = System.currentTimeMillis();
        System.out.println("Start Time: " + startTime + " ms");

        System.out.println("Adding "+ maxElementsToInsert + " number of elements into the queue");
        for (int i = 0; i < maxElementsToInsert ; i++) {
            queue.offer(i);
        }

        System.out.println("Peeking top element in the queue: " + queue.peek());

        System.out.println("Removing " + maxElementsToInsert + " number of elements from the queue");
        for (int i = 0; i < maxElementsToInsert ; i++) {
            queue.poll();
        }

        System.out.println("Peeking top element in the queue: " + queue.peek());

        // End time in milliseconds
        long endTime = System.currentTimeMillis();
        System.out.println("End Time: " + endTime + " ms");

        // Total execution time
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");

        System.out.println("===================================== END =====================================");

    }

}
