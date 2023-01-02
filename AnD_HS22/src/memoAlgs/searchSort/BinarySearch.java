package memoAlgs.searchSort;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file implements iterative and recursive binary search.
*/

public class BinarySearch {
    public static void main(String[] args) {
        // sorted input
        int[] in = {Integer.MIN_VALUE, Integer.MIN_VALUE + 2, -2, 0, 2, 
                Integer.MAX_VALUE - 2, Integer.MAX_VALUE};

        // value to search
        int val = -8;
        
        // get info
        printInfo(in, val, recBinarySearch(in, val, 0, in.length), "rec");
        printInfo(in, val, iterBinarySearch(in, val, 0, in.length), "iter");   
    }

    // returns key, if not in array key of next smaller element
    // recursive for theory
    public static int recBinarySearch(int[] in, int val, int l, int r) {
        // new mid
        int m = (l + r) / 2;
        // base case: found or not in there
        // true / false wanted: split
        if (in[m] == val || l > r) {
            return m;
        }

        // continue search
        // go right
        if (val > in[m]) {
            return recBinarySearch(in, val, m + 1, r);
        // go left
        } else {
            return recBinarySearch(in, val, l, m - 1);
        }
    }

    // returns key, if not in array key of next smaller element
    // iterative for code expert
    public static int iterBinarySearch(int[] in, int val, int l, int r) {
        // store mid
        int m = 0;
        while (l < r) {
            // new mid
            m = (l + r) / 2;
            // found
            // true / false wanted: here true
            if (in[m] == val) {
                return m;
            }
            
            // continue search
            // go right
            if (val > in[m]) {
                l = m + 1;
            // go left
            } else {
                r = m - 1;
            }
        }
        // not found, if true / false wanted: here false
        return m;
    }

    // print info
    public static void printInfo(int[] in, int val, int key, String name) {
        System.out.println("result for " + val + " with method " + name + 
                ": got key " + key + ", element at key: " + in[key]);
    }

}
