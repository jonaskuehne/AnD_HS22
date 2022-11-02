/*
Author: J. Kuehne
Date: 12.10.2022
Lecture: AnD
Project: Exercise 4
Summary:
    This file is used to show the correctness of the algorithm in 4.4 a).
*/

public class SummitSearch {
    public static void main(String[] args) {
        // => index starts at 1 as exercise formulated like this
        int[] A = {1, 2, 3, 4, 0};

        int start = 1;
        int end = A.length;

        while (true) {
            int m = (start + end) / 2;
            // base case
            if (start == m) {
                // correct for upper bound
                if (m == A.length - 1) {
                    ++m;
                }
                System.out.println(m + ": " + A[m - 1]);
                break;
            }

            // found
            if (A[m - 1 - 1] < A[m - 1] && A[m - 1] > A[m + 1 - 1]) {
                System.out.println(m + ": " + A[m - 1]);
                break;
            }

            // not found -> search upper half
            if (A[m - 1 - 1] < A[m - 1]) {
                start = m;
            // not found -> search lower half
            } else {
                end = m;
            }
        }
    }
}
