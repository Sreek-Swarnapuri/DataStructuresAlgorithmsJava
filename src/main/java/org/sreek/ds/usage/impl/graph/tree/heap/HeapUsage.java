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
            integerHeap.push(val);
        }

        integerHeap.printHeapArray();

        logger.info("extracting {} element from heap - {}", integerHeap.isMinHeap()? "Min" : "Max" , integerHeap.pop() );

        integerHeap.printHeapArray();

        integerHeap = new Heap<>(Integer.class, false);


        integerHeap.buildHeapFromArray(new Integer[]{1, 2, 4, 5, 3});
        // Should be: 5 3 4 2 1
        integerHeap.printHeapArray();

    }

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;

        ListNode newList = null;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                if(newList == null) {
                    newList = new ListNode(list1.val);
                } else {
                    newList.next = new ListNode(list1.val);
                }
                list1 = list1.next;
            } else {
                if(newList == null) {
                    newList = new ListNode(list2.val);
                } else {
                    newList.next = new ListNode(list2.val);
                }
                list2 = list2.next;
            }
            newList = newList.next;
        }

        while(list1 != null) {
            newList.next = new ListNode(list1.val);
            list1 = list1.next;
            newList = newList.next;
        }
        while(list2 != null) {
            newList.next = new ListNode(list2.val);
            list2 = list2.next;
            newList = newList.next;
        }
        return newList;
    }

}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }