package memoAlgs.searchSort;

import java.util.PriorityQueue;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file implements heapsort (in case we get prioqueue).
*/

public class HeapSort {
    
    // sorts array using prio queue
    public static void sort(int[] in) {
        // create heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // fill heap
        for (int i : in) {
            heap.add(i);
        }
        // sort
        for (int i = 0; i < in.length; ++i) {
            in[i] = heap.poll();
        }
    }

}