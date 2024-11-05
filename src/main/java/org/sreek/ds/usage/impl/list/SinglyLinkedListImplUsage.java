package org.sreek.ds.usage.impl.list;

import org.sreek.ds.implementation.list.SinglyLinkedList;

public class SinglyLinkedListImplUsage {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> numericalLinkedList = new SinglyLinkedList<>();

        numericalLinkedList.printLinkedList();

        numericalLinkedList.insertAtHead(16);
        numericalLinkedList.printLinkedList();
        numericalLinkedList.insertAtHead(8);
        numericalLinkedList.printLinkedList();
        numericalLinkedList.insertAtHead(2);
        numericalLinkedList.insertAtHead(1);
        numericalLinkedList.printLinkedList();

        numericalLinkedList.insert(2, 4);
        numericalLinkedList.printLinkedList();

        try {
            numericalLinkedList.insert(6, 32);
            numericalLinkedList.printLinkedList();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("exception thrown");
            e.printStackTrace();
        }

        try {
            numericalLinkedList.insert(7, 32);
            numericalLinkedList.printLinkedList();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("exception thrown");
            e.printStackTrace();
        }

        System.out.println("deleting value: " + numericalLinkedList.deleteAtHead());
        numericalLinkedList.printLinkedList();

        System.out.println("deleting value: " + numericalLinkedList.deleteAtEnd());
        numericalLinkedList.printLinkedList();

        System.out.println("deleting value: " + numericalLinkedList.delete(0));
        numericalLinkedList.printLinkedList();

        System.out.println("deleting value: " + numericalLinkedList.delete(numericalLinkedList.size() - 1));
        numericalLinkedList.printLinkedList();

        numericalLinkedList.insertAtHead(3);
        numericalLinkedList.insertAtHead(2);
        numericalLinkedList.insertAtHead(1);
        numericalLinkedList.printLinkedList();
        System.out.println("deleting value: " + numericalLinkedList.delete(2));
        numericalLinkedList.printLinkedList();

        try {
            System.out.println("deleting value: " + numericalLinkedList.delete(numericalLinkedList.size()));
            numericalLinkedList.printLinkedList();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("exception thrown");
            e.printStackTrace();
        }

        try {
            System.out.println("deleting value: " + numericalLinkedList.delete(6));
            numericalLinkedList.printLinkedList();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("exception thrown");
            e.printStackTrace();
        }

        System.out.println("Element at index 2 is: " + numericalLinkedList.get(2));
        System.out.println("Element at index 1 is: " + numericalLinkedList.get(1));
        System.out.println("does linked list contain element with data 4: " + numericalLinkedList.contains(4));
        System.out.println("does linked list contain element with data 10: " + numericalLinkedList.contains(10));

        System.out.println("Initializing a new Singly Linked List using another linked list");
        SinglyLinkedList<Integer> integerSinglyLinkedList = new SinglyLinkedList<>(numericalLinkedList);
        integerSinglyLinkedList.printLinkedList();

        numericalLinkedList.clear();

        try {
            System.out.println("Initializing a new Singly Linked List using another linked list");
            SinglyLinkedList<Integer> integerSinglyLinkedList1 = new SinglyLinkedList<>(numericalLinkedList);
            integerSinglyLinkedList.printLinkedList();
        } catch (IllegalArgumentException e) {
            System.out.println("Error thrown while creating a new linked list");
            e.printStackTrace();
        }

    }

}
