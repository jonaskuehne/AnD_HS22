package ex10;

import java.util.ArrayList;
import java.util.Arrays;

/*
Author: J. Kuehne
Date: 29.11.2022
Lecture: AnD
Project: Exercise 10
Summary:
    This file is used to show the correctness of the algorithm in 10.2.
*/

public class LongestPath {
    public static void main(String[] args) {
        // input
        // array for convenience
        int[][] adj = {{1, 5}, {}, {0}, {}, {3}, {1, 4}};

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

        // dp table
        int[] table = new int[adj.length];
        Arrays.fill(table, -1);

        // fill table
        for (int v = 0; v < adjList.size(); ++v) {
            // check if already computed, else do nothing
            if (table[v] < 0) {
                // do search
                dfs(v, adjList, table);
            }
        }

        // get max
        int max = 0;
        for (int l : table) {
            max = Math.max(max, l);
        }
        System.out.println(max);
    }

    // does dfs
    public static void dfs(int v, ArrayList<ArrayList<Integer>> adjList, 
            int[] table) {
        // go through neighbors
        int max = -1;
        for (int e : adjList.get(v)) {
            // not already done
            if (table[e] < 0) {
                dfs(e, adjList, table);
            }
            // get max
            max = Math.max(max, table[e]);
        }
        table[v] = max + 1;
    }
}