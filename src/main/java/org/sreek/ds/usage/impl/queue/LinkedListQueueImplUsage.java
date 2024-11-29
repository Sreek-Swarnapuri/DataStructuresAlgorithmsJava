package org.sreek.ds.usage.impl.queue;

import org.sreek.ds.implementation.queue.LinkedListQueue;

public class LinkedListQueueImplUsage {

    public static void main(String[] args) {
        LinkedListQueue<Integer> iQ = new LinkedListQueue<>();

        System.out.println("Queue is " + iQ);
        iQ.enqueue(1);
        iQ.enqueue(2);
        iQ.enqueue(3);
        iQ.enqueue(4);
        iQ.enqueue(5);
        iQ.enqueue(6);
        System.out.println("Queue is " + iQ);

        System.out.println("Element out of Queue: " + iQ.dequeue());
        System.out.println("Element out of Queue: " + iQ.dequeue());
        System.out.println("Element out of Queue: " + iQ.dequeue());
        System.out.println("Element out of Queue: " + iQ.dequeue());
        System.out.println("Queue is " + iQ);

        System.out.println("Element out of Queue: " + iQ.dequeue());
        System.out.println("Element out of Queue: " + iQ.dequeue());
        System.out.println("Element out of Queue: " + iQ.dequeue());
        System.out.println("Queue is " + iQ);
        System.out.println("Size of the queue: " + iQ.size());

        iQ.enqueue(2);
        iQ.enqueue(10);
        iQ.enqueue(12);
        iQ.enqueue(573);

        System.out.println("Top of the queue: " + iQ.top());
        System.out.println("Queue is " + iQ);
        System.out.println("Element out of Queue: " + iQ.dequeue());
        System.out.println("Element out of Queue: " + iQ.dequeue());
        System.out.println("is Queue empty? " + iQ.isEmpty());
        System.out.println("Element out of Queue: " + iQ.dequeue());
        System.out.println("Element out of Queue: " + iQ.dequeue());
        System.out.println("Queue is " + iQ);
        System.out.println("Size of the queue: " + iQ.size());
        System.out.println("Top of the queue: " + iQ.top());
        System.out.println("is Queue empty? " + iQ.isEmpty());

        LinkedListQueue<String> sQ = new LinkedListQueue<>("First");

        sQ.enqueue("Second");
        sQ.enqueue("Third");
        sQ.enqueue("Fourth");
        sQ.enqueue("Fifth");
        System.out.println("Queue is " + sQ);
        System.out.println("Size of the queue: " + sQ.size());
        System.out.println("Top of the queue: " + sQ.top());
        System.out.println("is Queue empty? " + sQ.isEmpty());

        sQ.clear();
        System.out.println("Queue is " + sQ);
        System.out.println("Size of the queue: " + sQ.size());
        System.out.println("Top of the queue: " + sQ.top());
        System.out.println("is Queue empty? " + sQ.isEmpty());

    }

}
