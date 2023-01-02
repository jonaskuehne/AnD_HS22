package memoAlgs.searchSort;

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
    }

    // print info
    public static void printSearchInfo(int[] in, int val, int key, String name) {
        System.out.println("result for " + val + " with method " + name + 
                ": got key " + key + ", element at key: " + in[key]);
    }

}
