package memoAlgs.graphs;

import java.util.ArrayList;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file implements Johnsons algorithm.
*/

public class Johnson {
    // used for its original purpose (all-pairs shortest path)
    public static int[][] shortestPath(ArrayList<ArrayList<Edge>> graph, int n) {
        // init distances
        int[][] d = new int[n][];

        // add edges from new node to everything
        graph.add(new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            graph.get(n).add(new Edge(n, i, 0));
        }

        // get list for Bellman-Ford
        ArrayList<Edge> listGraph = new ArrayList<>();
        for (ArrayList<Edge> edges : graph) {
            for (Edge e : edges) {
                listGraph.add(e);
            }
        }

        // get distances with Bellman-Ford
        int[] h = BellmanFord.shortestPaths(listGraph, n, n + 1);

        // adjust edge costs (can leave new node in there, no effect)
        for (Edge e : listGraph) {
            e.cost = e.cost + h[e.from] - h[e.to];
        }

        // run dijkstra
        for (int i = 0; i < n; ++i) {
            d[i] = Dijkstra.shortestPaths(graph, i);
        }

        // return distances
        return d;
    }
}
