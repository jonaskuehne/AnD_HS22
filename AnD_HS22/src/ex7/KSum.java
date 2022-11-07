package ex7;

/*
Author: J. Kuehne
Date: 07.11.2022
Lecture: AnD
Project: Exercise 7
Summary:
    This file is used to show the correctness of the algorithm in 7.1.
*/

public class KSum {
    public static void main(String[] args) {
        // input
        int n = 36;
        int k = 3;
        int dimK = (int)Math.pow(n, 1.0/k);

        // potence stuff
        int[] a = new int[dimK + 1];

        // fill
        for (int i = 0; i < a.length; ++i){
            a[i] = (int)Math.pow(i, k);
        }

        // table
        boolean[][] table = new boolean[dimK + 1][n + 1];

        // base case (use that java initializes boolean as false)
        table[0][0] = true;

        // column
        for (int col = 0; col < table[0].length; ++col) {
            // row
            for (int row = 1; row < table.length; ++row) {
                // prevent out of bound
                try {
                    // use short circuiting
                    table[row][col] = table[row - 1][col] || 
                        table[row - 1][col - a[row]];
                } catch (ArrayIndexOutOfBoundsException e) {
                    // do nothing -> stays false
                }
            }
        }

        // print solution
        System.out.println(table[table.length - 1][table[0].length - 1]);

    }
}
