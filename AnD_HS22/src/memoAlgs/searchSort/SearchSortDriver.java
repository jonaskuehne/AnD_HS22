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
        searchDemo();
        // sort
        sortDemo();
    }

    // search stuff
    public static void searchDemo() {
        System.out.println("SEARCH");
        // sorted input
        final int[] in = {Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 2, -2, 0, 2, 
            Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1};
        System.out.println("input: " + Arrays.toString(in));

        // value to search
        int val = Integer.MAX_VALUE;

        // get info
        printSearchInfo(in, val, 
                BinarySearch.recBinarySearch(in, val, 0, in.length - 1), 
                "rec");
        printSearchInfo(in, val, 
                BinarySearch.iterBinarySearch(in, val, 0, in.length - 1), 
                "iter");
    }

    // sort stuff
    public static void sortDemo() {
        System.out.println("SORT");
        // input
        final int[] in = new int[]{2323, 3, 3, 422, 454, -123, Integer.MIN_VALUE, 
                Integer.MAX_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("input: " + Arrays.toString(in));
        
        // heapsort
        int[] inHeap = in.clone();
        HeapSort.sort(inHeap);
        printSortInfo(inHeap, "heap");
        
        // recursive mergesort
        int[] inRecMerge = in.clone();
        MergeSort.recMergeSort(inRecMerge, 0, inRecMerge.length - 1);
        printSortInfo(inRecMerge, "recMerge");
        
        // iterative mergesort
        int[] inItrMerge = in.clone();
        MergeSort.iterMergeSort(inItrMerge);
        printSortInfo(inItrMerge , "itrMerge");
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
