package org.sreek.ds.usage.impl.graph.tree.heap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sreek.ds.implementation.graph.tree.heap.Heap;

public class HeapUsage {

    private static final Logger logger = LogManager.getLogger(HeapUsage.class);

    public static void main(String[] args) {


        int[] intArr = {2, 1, 3};

        Heap<Integer> integerHeap = new Heap<>(Integer.class, true);

        for (int val: intArr) {
            integerHeap.insert(val);
        }

        integerHeap.printHeapArray();

        logger.info("extracting {} element from heap - {}", integerHeap.isMinHeap()? "Min" : "Max" , integerHeap.pop() );

        integerHeap.printHeapArray();

    }

}
