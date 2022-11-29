package ex10;

import java.util.ArrayList;
import java.util.Arrays;

/*
Author: J. Kuehne
Date: 29.11.2022
Lecture: AnD
Project: Exercise 10
Summary:
    This file is used to show the correctness of the algorithm in 10.3.
*/

public class SubtreeSum {
    public static void main(String[] args) {
        // input
        int root = 0;
        // array for convenience
        int[][] adj = {{1, 2}, {3, 4}, {5, 6}, {7, 8, 9}, {10}, {}, {}, {}, {}, 
                {}, {}};

        // put into list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        // vertex
        for (int v = 0; v < adj.length; ++v) {
            // init
            adjList.add(new ArrayList<>());
            // edge
            for (int e = 0; e < adj[v].length; ++e) {
                // add
                adjList.get(v).add(adj[v][e]);
            }

        }

        // array for memoization
        int[] memo = new int[adj.length];

        // compute
        subtreeSum(root, adjList, memo);

        // output
        System.out.println(Arrays.toString(memo));
    }

    // compute subtree sum recursively
    public static void subtreeSum(int r, ArrayList<ArrayList<Integer>> adjList, 
            int[] memo) {
        // counter for sum, by example leaf is 1 apparently
        int sum = 1;
        
        // for each edge
        for (int v : adjList.get(r)) {
            // execute for child -> get number of children
            subtreeSum(v, adjList, memo);
            // sum of children
            sum += memo[v];
        }

        // write to memo
        memo[r] = sum;
    }
}
