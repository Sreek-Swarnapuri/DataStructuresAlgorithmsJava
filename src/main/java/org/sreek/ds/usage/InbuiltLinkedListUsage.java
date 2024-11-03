package org.sreek.ds.usage;

import java.util.LinkedList;

public class InbuiltLinkedListUsage {

    public static void main(String[] args) {

        System.out.println("---------Characters Linked List----------");
        LinkedList<Character> charLinkedList = new LinkedList<>();

        charLinkedList.add('a');
        charLinkedList.add('b');
        charLinkedList.add('c');
        System.out.println(charLinkedList);
        charLinkedList.add('a');
        charLinkedList.add('a');
        System.out.println(charLinkedList);
        // By default remove() accepts index, inorder to remove an element with a certain data, we should use WrapperClass.valueOf() methood.
        charLinkedList.remove(Character.valueOf('c'));
        System.out.println(charLinkedList);
        charLinkedList.add(2,'c');
        System.out.println(charLinkedList);
        charLinkedList.remove(4);
        System.out.println(charLinkedList);
        // throws IndexOutOfBoundsException
        //charLinkedList.remove(4);
        System.out.println("element at position 2: " + charLinkedList.get(2));
        System.out.println("Does Llist contain `c`? " + charLinkedList.contains('c'));
        System.out.println("Is Linked list empty? " + charLinkedList.isEmpty());
        System.out.println("Clearning Linked list:");
        charLinkedList.clear();
        System.out.println("Linked list is : " + charLinkedList);
        System.out.println("Is Linked list empty? " + charLinkedList.isEmpty());
        System.out.println("---------Characters Linked List----------");

        System.out.println();

        System.out.println("---------Integer Linked List----------");
        LinkedList<Integer> linkedIntegers = new LinkedList<>();
        linkedIntegers.add(1);
        linkedIntegers.add(2);
        linkedIntegers.add(3);
        linkedIntegers.add(4);
        System.out.println(linkedIntegers);
        // By default remove() accepts index, inorder to remove an element with a certain data, we should use WrapperClass.valueOf() methood.
        linkedIntegers.remove(Integer.valueOf(3));
        System.out.println(linkedIntegers);
        System.out.println("---------Integer Linked List----------");
        System.out.println();
    }

}
