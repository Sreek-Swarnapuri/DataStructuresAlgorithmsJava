package org.sreek.ds.usage;

public class ArrayUsage {

    public static void main(String[] args) {
        int[] numbers = new int[5];

        System.out.println("Numbers in an uninitialized int array:");
        for (int num: numbers) {
            System.out.println(num);
        }

        numbers[0] = 0;
        numbers[1] = 2;
        numbers[2] = 4;
        numbers[3] = 6;
        numbers[4] = 8;

        System.out.println("Numbers array post initialization:");
        for (int num: numbers) {
            System.out.println(num);
        }

    }

}
