package ex7;

/*
Author: J. Kuehne
Date: 08.11.2022
Lecture: AnD
Project: Exercise 7
Summary:
    This file is used to show the correctness of the algorithm in 7.4.
    Idea: compute number of strings w/ atleast k consecutive 1's
    and number of strings w/ atleast k + 1 consecutive 1's.
    Return difference.
*/

public class StringCounting {
    public static void main(String[] args) {
        // input
        int n = 10;
        int k = 3;

        // base case
        if (n == k) {
            System.out.println(1);
            System.exit(0);
        }

        // create arrays
        int len = n - k + 1;
        int[] pow = new int[len];
        pow[0] = 1;

        int[] smallK = new int[len];
        smallK[0] = 1;

        int[] bigK = new int[len];
        bigK[1] = 1;

        // fill tables
        for (int i = 1; i < len; ++i) {
            // power array
            pow[i] = 2 * pow[i - 1];

            // table w/ k
            smallK[i] = 2 * smallK[i - 1] + pow[i - 1];
            // correction if necessary
            if (i - k - 1 >= 0) {
                smallK[i] -= smallK[i - k - 1];
            }
            
            // table w/ k+1
            if (i > 1) {
                bigK[i] = 2 * bigK[i - 1] + pow[i - 2];
                // correction if necessary
                if (i - k - 2 >= 0) {
                    bigK[i] -= bigK[i - k - 2];
                }
            }
        }

        // get solution
        int num = smallK[len - 1] - bigK[len - 1];
        System.out.println(num);
    }
}
