package org.sreek.ds.usage;

import org.sreek.ds.implementation.SinglyLinkedList;

import java.util.LinkedList;

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

        numericalLinkedList.insert(6, 32);
        numericalLinkedList.printLinkedList();
        numericalLinkedList.insert(7, 32);
        numericalLinkedList.printLinkedList();

    }

}
