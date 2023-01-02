package memoAlgs.graphs;

import java.util.ArrayList;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file implements DFS.
*/

public class DFS {
    // general idea, here used to detect cycles -> also poss. w/ BFS
    /*
     * really need iterative variant and BFS no sufficient: 
     * BFS with stack instead of queue
     */
    public static boolean hasCycle(ArrayList<ArrayList<Integer>> graph) {
        // track visited
        boolean[] visited = new boolean[graph.size()];

        // for all
        for (int u = 0; u < graph.size(); ++u) {
            // store visited for each recursive call
            boolean[] recVisited = new boolean[graph.size()];
            // not marked yet
            if (!visited[u]) {
                if (visit(visited, recVisited, graph, u)) {
                    return true;
                }
            }
        }
        // nothing found
        return false;
    }

    // recursive helper
    public static boolean visit(boolean[] visited, boolean recVisited[],
            ArrayList<ArrayList<Integer>> graph, int current) {
        // mark as visited
        visited[current] = true;
        recVisited[current] = true;
        // all successors
        for (int u : graph.get(current)) {
            // already seen in recursive stack
            if (recVisited[u]) {
                return true;
            }
            // not marked
            if (!visited[u]) {
                // recursion
                if (visit(visited, recVisited, graph, u)) {
                    return true;
                }
            }
        }
        // want topol. sort: add current here, reverse list after dfs
        return false;
    }
}
