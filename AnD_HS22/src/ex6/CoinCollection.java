package ex6;

/*
Author: J. Kuehne
Date: 01.11.2022
Lecture: AnD
Project: Exercise 6
Summary:
    This file is used to show the correctness of the algorithms in 6.4.
*/

public class CoinCollection {
    public static void main(String[] args) {
        // input general
        char[][] A = {{'.', 'C', 'C', '.', 'C', '.'},
                      {'.', '#', 'C', 'C', 'C', '#'},
                      {'C', '.', '.', '.', '#', '#'},
                      {'.', 'C', '#', '#', '#', 'C'},
                      {'.', 'C', '.', '.', 'C', '.'}};
        int startRow = 0;
        int startCol = 0;

        // input c)
        int[][] memo = new int[A.length][A[0].length];
        for (int i = 0; i < memo.length; ++ i) {
            for (int j = 0; j < memo[0].length; ++j) {
                memo[i][j] = -1;
            }
        }
        
        System.out.println("res with a) :" + 
            recCoinFind(A.length, A[0].length, startRow, startCol, A));

        System.out.println("res with c) :" + 
            memoCoinFind(A.length, A[0].length, startRow, startCol, A, 
            memo));

        System.out.println("res with d) :" + 
            dpCoinFind(A.length, A[0].length, startRow, startCol, A));
    }

    // task a)
    public static int recCoinFind(int m, int n, int i, int j, char[][] A) {
        // base cases
        if (i >= m || j >= n){
            return 0;
        }
        if (A[i][j] == '#') {
            return 0;
        }

        // recursive case
        int coin = 0;
        // found
        if (A[i][j] == 'C') {
            ++coin;
        }

        return coin + Math.max(recCoinFind(m, n, i + 1, j, A), 
            recCoinFind(m, n, i, j + 1, A));

    }

    // task c)
    public static int memoCoinFind(int m, int n, int i, int j, char[][] A, int[][] memo) {
        // base cases
        if (i >= m || j >= n){
            return 0;
        }
        if (A[i][j] == '#') {
            return 0;
        }

        // already computed
        if (memo[i][j] >= 0) {
            return memo[i][j];
        }

        // recursive case
        int coin = 0;
        // found
        if (A[i][j] == 'C') {
            ++coin;
        }
        // store
        memo[i][j] = coin + Math.max(memoCoinFind(m, n, i + 1, j, A, memo), 
        memoCoinFind(m, n, i, j + 1, A, memo));

        return memo[i][j];
    }

    // task d)
    public static int dpCoinFind(int m, int n, int i, int j, char[][] A) {
        int[][] dpTable = new int[m][n];
        int max = 0;

        // fill
        for (int row = i; row < m; ++row) {
            for (int col = j; col < n; ++col) {
                // no passage
                if (A[row][col] == '#') {
                    dpTable[row][col] = -1;
                    continue;
                }
                // indices for later comparison
                int compRow = row;
                int compCol = col;

                // bound up
                if (row > i) {
                    --compRow;
                }
                // bound left
                if (col > j) {
                    --compCol;
                }

                int coin = 0;
                // found coin, check if accessible
                if (A[row][col] == 'C' && 
                    (dpTable[compRow][col] >= 0 | dpTable[row][compCol] >= 0)) {
                    ++coin;
                }

                // add entry, check max
                dpTable[row][col] = coin + 
                    Math.max(dpTable[compRow][col], dpTable[row][compCol]);

                max = Math.max(max, dpTable[row][col]);
            }
        }

        return max;
    }
}
