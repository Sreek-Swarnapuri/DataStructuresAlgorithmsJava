package org.sreek.ds.usage;

import org.sreek.ds.implementation.DoublyLinkedList;

public class DoublyLinkedListImplUsage {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> integerLinkedList = new DoublyLinkedList<>();

        // Insert at head
        integerLinkedList.insertAtHead(1);
        integerLinkedList.print();

        // Insert at end
        integerLinkedList.insertAtEnd(2);
        integerLinkedList.insertAtEnd(7);
        integerLinkedList.insertAtEnd(8);
        integerLinkedList.insertAtEnd(9);
        integerLinkedList.print();

        // Insert in the middle
        integerLinkedList.insert(2,3);
        integerLinkedList.print();

        // delete at head
        System.out.println("Element deleted at head is " + integerLinkedList.deleteAtHead());
        integerLinkedList.print();

        // delete at end
        System.out.println("Element deleted at end is " + integerLinkedList.deleteAtEnd());
        integerLinkedList.print();

        // delete from middle
        System.out.println("Element deleted at index 2 is " + integerLinkedList.delete(2));
        integerLinkedList.print();

        // clear
        System.out.println("Clearing Linked list");
        integerLinkedList.clear();
        integerLinkedList.print();

        integerLinkedList.insert(0,2);
        integerLinkedList.insert(1,6);
        integerLinkedList.insert(1,3);
        integerLinkedList.insert(3,7);
        integerLinkedList.insert(2,4);
        integerLinkedList.insert(3,5);
        integerLinkedList.insert(0,1);
        integerLinkedList.insert(0,-21);
        integerLinkedList.print();

        // get
        System.out.println("Element at index 3 is " + integerLinkedList.get(3));

        // contains
        System.out.println("Does the Linked list contain 4? " + integerLinkedList.contains(4));
        System.out.println("Does the Linked list contain 40? " + integerLinkedList.contains(40));
        System.out.println("Does the Linked list contain 2? " + integerLinkedList.contains(2));
        System.out.println("Does the Linked list contain -21? " + integerLinkedList.contains(-21));
        System.out.println("Does the Linked list contain -2? " + integerLinkedList.contains(-2));


        // create DLL with 1 element
        DoublyLinkedList<Integer> numbersList = new DoublyLinkedList<>(2);
        numbersList.print();
        numbersList.deleteAtEnd();
        numbersList.print();
        numbersList.insertAtEnd(3);
        numbersList.print();
        numbersList.insert(1,2);
        numbersList.print();


        // copy DLL to a new DLL
        DoublyLinkedList<Integer> numbersList2 = new DoublyLinkedList<>(integerLinkedList);
        numbersList2.print();

    }

}
