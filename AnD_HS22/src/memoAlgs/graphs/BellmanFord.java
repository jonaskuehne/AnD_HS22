package memoAlgs.graphs;

import java.util.List;
import java.util.Arrays;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file implements (Bellman and Ford)s algorithm.
*/

public class BellmanFord {
    // general idea, here used to detect negative cycles
    public static int[] shortestPaths(List<Edge> graph, int start, int n) {
        // store distances
        int[] d = new int[n];
        // init
        // max_val / 2 to prevent overflow
        Arrays.fill(d, Integer.MAX_VALUE / 2);
        d[start] = 0;

        // "l-nice" (hehe) bound
        for (int i = 0; i < n - 1; ++i) {
            // for each edge
            for (Edge e : graph) {
                d[e.to] = Math.min(d[e.to], d[e.from] + e.cost);
            }
        }

        // now again, something changes -> negative cycle
        // for each edge
        for (Edge e : graph) {
            if (d[e.to] > d[e.from] + e.cost) {
                System.out.println("negative cycle!");
                return d;
            }
        }
        System.out.println("no negative cycle");
        return d;
    }
}