package ex7;

/*
Author: J. Kuehne
Date: 08.11.2022
Lecture: AnD
Project: Exercise 7
Summary:
    This file is used to show the correctness of the algorithm in 7.3.
*/

public class SafePawnLine {
    public static void main(String[] args) {
        // sample input
        boolean[][] board = {{true, false, true, false, true, false},
                             {false, true, false, true, false, true},
                             {false, false, true, false, false, false},
                             {false, true, false, true, false, false},
                             {true, false, true, false, true, false},
                             {false, false, false, false, false, true}};
        
        // dim
        int n = board.length;
        int m = board[0].length;

        // create table
        int[][] table = new int[n][m];

        // init -> first column
        for (int row = 0; row < n; ++row) {
            // start of possible row, other entries 0
            if (board[row][0]) {
                table[row][0] = 1;
            }
        }

        // fill table
        // col, skip first one
        for (int col = 1; col < m; ++ col) {
            // row
            for (int row = 0; row < n; ++row) {
                // pawn here
                if (board[row][col]) {
                    // prevent out of bound
                    // can look at last row
                    if (row > 0) {
                        table[row][col] += table[row - 1][col - 1];
                    }
                    // can look at next row
                    if (row < n - 1) {
                        table[row][col] += table[row + 1][col - 1];
                    }
                }
            }
        }

        // extract solution
        int lines = 0;
        for (int row = 0; row < n; ++row) {
            lines += table[row][m - 1];
        }

        // give output
        System.out.println(lines);
    }
}
