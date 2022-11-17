package ex8;

import java.util.Stack;

/*
Author: J. Kuehne
Date: 15.11.2022
Lecture: AnD
Project: Exercise 8
Summary:
    This file is used to show the correctness of the algorithm in 8.5.
*/

public class StackComputation {
    public static void main(String[] args) {
        // input
        // array as convenience
        int[] in = {7, 2, 3, 4};

        // convert to stack
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = in.length - 1; i >= 0; --i) {
            stack.push(in[i]);
        }

        int c = 10;

        // invalid input
        if (c <= 0) {
            System.out.println("invalid");
            System.exit(-1);
        }

        // dp-table
        boolean[][] table = new boolean[c][in.length];

        // base case
        int base = stack.pop();
        if (base <= c) {
            table[base - 1][0] = true;
        }

        // fill table
        // column
        for (int col = 1; col < table[0].length; ++col) {
            // general updates
            // element itself
            int elem = stack.pop();
            if (elem <= c) {
                table[elem - 1][col] = true;
            }
            // row
            for (int row = 0; row < table.length; ++row) {
                // last one computable
                if (table[row][col - 1]) {
                    // addition with last
                    if ((row + 1) + elem <= c) {
                        table[(row + 1) + elem - 1][col] = true;
                    }
                    // multiplication with last
                    if ((row + 1) * elem <= c) {
                        table[(row + 1) * elem - 1][col] = true;
                    }
                }
            }
        }

        // check if solution found
        for (int i = 0; i < table[table.length - 1].length; ++i) {
            // yes
            if (table[table.length - 1][i]) {
                System.out.println("computable");
                System.exit(0);
            }
        }
        // no
        System.out.println("uncomputable");
    }
}
