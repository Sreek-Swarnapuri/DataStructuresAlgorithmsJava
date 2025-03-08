package org.sreek.ds.usage.builtin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Arrays {

    private static final Logger logger = LogManager.getLogger(Arrays.class);

    public static void main(String[] args) {
        int[] numbers = new int[5];

        System.out.println("Numbers in an uninitialized int array:");
        printArray(numbers);

        numbers[0] = 0;
        numbers[1] = 2;
        numbers[2] = 4;
        numbers[3] = 6;
        numbers[4] = 8;

        System.out.println("Numbers array post initialization:");
        printArray(numbers);

        // changing the value of any particular index:
        numbers[4] = 1;
        System.out.println("updated array:");
        printArray(numbers);

        // Array is of fixed size if we try to access an index out of its size ( out of 0 to n-1, n being  size of array)
        //      it will throw an exception
        try {
            numbers[5] = 3;
        } catch (IndexOutOfBoundsException e) {
            logger.error("Cannot access the index provided as it is out of provided size - {}", e.getMessage());
        }

        System.out.println("====================================== 2-Dimensional Array ======================================");

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("-----Printing each row-----");
        for(int[] row: matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }

        System.out.println("-----Printing each column as an array-----");
        for (int i = 0; i < matrix[0].length; i++) {
            int[] columns = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                columns[j] = matrix[j][i];
            }
            System.out.println(java.util.Arrays.toString(columns));
        }



    }

    static void printArray(int[] arr) {
        System.out.println("Printing array of type: " + arr.getClass().getComponentType().getName());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + ": " + arr[i]);
            if (i < arr.length - 1)
                System.out.print(" , ");
        }
        System.out.println();
    }

}
