package memoAlgs.graphs;

import java.util.List;
import java.util.Arrays;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file implements (FloydWarshall)s algorithm.
*/

public class FloydWarshall {

    // used for its original purpose (all-pairs shortest path)
    public static int[][] shortestPath(List<Edge> graph, int n) {

        // init
        int[][] d = new int[n][n];
        // not reachable
        for (int i = 0; i < n; ++i) {
            // / 2 to prevent overflow
            Arrays.fill(d[i], Integer.MAX_VALUE / 2);
        }
        // diagonal
        for (int i = 0; i < n; ++i) {
            d[i][i] = 0;
        }
        // directly reachable
        for (Edge e : graph) {
            d[e.from][e.to] = e.cost;
        }

        // dp
        // index vertices
        for (int i = 0; i < n; ++i) {
            // from
            for (int x = 0; x < n; ++x) {
                // to
                for (int y = 0; y < n; ++y) {
                    // if larger init than max / 2 prevent overflow here
                    d[x][y] = Math.min(d[x][y], d[x][i] + d[i][y]);
                }
            }
        }

        return d;
    }

}
