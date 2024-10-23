package org.sreek.ds.usage;

import java.util.ArrayList;
import java.util.List;

public class ArrayListUsage {

    public static void main(String[] args) {

        // Declaration of List; used polymorphism
        List<Integer> numbersList = new ArrayList<>();

        System.out.println("Printing number list without initialization:");
        for (Integer num: numbersList) {
            System.out.println(num);
        }
        System.out.println("Nothing will be printed as there are no elements added to the ArrayList");

        numbersList.add(1);
        numbersList.add(12);
        numbersList.add(13);
        numbersList.add(132);
        numbersList.add(975);

        System.out.println("Printing numbers list post adding some elements");
        System.out.println("Length of the arrayList is: " + numbersList.size());
        int count = 0;
        for (Integer num: numbersList) {
            System.out.println(count + ": " + num);
            count++;
        }

        // In order to remove an element based on its value, we should use the WrapperClass.valueOf() for integers as the index values are of type int
        // which makes the remove(int index) method being called instead of remove(Object o) method that removes the element with provided value.
        numbersList.remove(Integer.valueOf(13));
        System.out.println("Printing numbers list post removing by value - 12");
        System.out.println("Length of the arrayList is: " + numbersList.size());
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.println(i + ": " + numbersList.get(i));
        }

        numbersList.remove(0);

        System.out.println("Printing numbers list post removing by index - 0");
        System.out.println("Length of the arrayList is: " + numbersList.size());
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.println(i + ": " + numbersList.get(i));
        }

        System.out.println("Length of the arrayList is: " + numbersList.size());

    }

}
