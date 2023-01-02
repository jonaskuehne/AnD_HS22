package memoAlgs.searchSort;

import java.util.Arrays;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file shows the implementations of the search / sort algorithms.
*/

public class SearchSortDriver {
    public static void main(String[] args) {
        // search

        // sorted input
        int[] in = {Integer.MIN_VALUE, Integer.MIN_VALUE + 2, -2, 0, 2, 
                Integer.MAX_VALUE - 2, Integer.MAX_VALUE};

        // value to search
        int val = -8;
        
        // get info
        printSearchInfo(in, val, 
            BinarySearch.recBinarySearch(in, val, 0, in.length), "rec");
        printSearchInfo(in, val, 
            BinarySearch.iterBinarySearch(in, val, 0, in.length), "iter");
            
        // sort
        in = new int[]{2323, 3, 3, 422, 454, -123, Integer.MIN_VALUE, Integer.MAX_VALUE};
        System.out.println("input: " + Arrays.toString(in));

        int[] inHeap = in.clone();
        HeapSort.sort(inHeap);
        printSortInfo(inHeap, "heap");

    }

    // print info
    public static void printSearchInfo(int[] in, int val, int key, String name) {
        System.out.println("binarysearch, type: " + name);
        System.out.println("result for " + val + ": got key " + key + 
                ", element at key: " + in[key]);
        System.out.println();
    }

    // print sort info
    public static void printSortInfo(int[] in, String name) {
        System.out.println("sort, type: " + name);
        System.out.println("result: " + Arrays.toString(in));
        System.out.println();
    }

}
