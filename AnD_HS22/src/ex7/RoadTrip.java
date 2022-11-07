package ex7;

/*
Author: J. Kuehne
Date: 07.11.2022
Lecture: AnD
Project: Exercise 7
Summary:
    This file is used to show the correctness of the algorithm in 7.2.
*/

public class RoadTrip {

    public static void main(String[] args) {
        // input
        int[] k = {5, 7, 13, 16, 25};
        int d = 10;

        int n = k.length - 1;

        // table
        boolean[][] table = new boolean[n][n];
        int count = 1;

        // column
        for (int col = 0; col < n; ++col) {
            // row
            for (int row = col; row < n; ++row) {
                // base case
                if (row == col) {
                    table[row][col] = true;
                    continue;
                }

                // next one legal
                if (k[row] - k[col] <= d) {
                    table[row][col] = true;
                    // additional solution
                    if (row - col >= 2) {
                        ++count;
                    }
                }
            }
        }

        System.out.println(count);
    }

}
