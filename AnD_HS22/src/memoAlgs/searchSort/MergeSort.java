package memoAlgs.searchSort;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file implements iterative and recursive mergesort.
*/

public class MergeSort {
    
    // recursive for theory
    public static void recMergeSort(int[] in, int l, int r) {
        // base case
        if (l >= r) {
            return;
        }

        // get mid
        int m = (l + r) / 2;
        // recursive case
        recMergeSort(in, l, m);
        recMergeSort(in, m + 1, r);
        // merge
        merge(in, l, m, r);
    }

    // iterative for code expert
    public static void iterMergeSort(int[] in) {
        // length of array -> -1 important!
        int n = in.length - 1;
        // length of already sorted
        // nothing yet
        int length = 1;
        // merge bottom up -> until n - 1 reached
        while (length <= n) {
            // starting point
            int l = 0;
            // merge
            while (l < n) {
                // go <length> to right
                int m = Math.min(l + length - 1, n);
                // go 2 * <length> to right
                int r = Math.min(l + 2 * length - 1, n);
                // merge
                merge(in, l, m, r);
                // adjust pointer
                l += 2 * length;
            }
            // next run twice of length
            length *= 2;
        }
    }

    

    // merges two sorted array partitions
    public static void merge(int[] in, int l, int m, int r) {
        int lSize = m - l + 1;
        int rSize = r - m;

        // temp arrays
        int[] left = new int[lSize];
        int[] right = new int[rSize];

        // fill
        for (int i = 0; i < lSize; ++i) {
            left[i] = in[i + l];
        }
        for (int i = 0; i < rSize; ++i) {
            right[i] = in[i + m + 1];
        }

        // indices for filling
        int lP = 0;
        int rP = 0;
        int inP = l;

        // fill w/ pointers
        while (lP < lSize && rP < rSize) {
            // take left
            if (left[lP] <= right[rP]) {
                in[inP] = left[lP];
                ++lP;
            // take right
            } else {
                in[inP] = right[rP];
                ++rP;
            }
            ++inP;
        }

        // remaining left
        while (lP < lSize) {
            in[inP] = left[lP];
            ++lP;
            ++inP;
        }

        // remaining right
        while (rP < rSize) {
            in[inP] = right[rP];
            ++rP;
            ++inP;
        }
    }
    
}
