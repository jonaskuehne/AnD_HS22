package memoAlgs.graphs;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file implements BFS.
*/

public class BFS {
    // general idea, here used to find shortest distances in unweighted graphs.
    public static int[] shortestPaths(ArrayList<ArrayList<Integer>> graph, 
            int start) {
        // store distances
        int[] d = new int[graph.size()];
        // init
        d[start] = 0;

        // queue -> stack for DFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        // track visited
        boolean[] visited = new boolean[graph.size()];

        while(!queue.isEmpty()) {
            // get element
            int u = queue.poll();
            // mark
            visited[u] = true;
            // for all successors
            for (int v : graph.get(u)) {
                // if is visited -> has cycle
                if (!visited[v]) {
                    // add to queue
                    queue.add(v);
                    // get distance -> unweighted -> cost 1
                    d[v] = d[u] + 1;
                }
            }
        }

        return d;
    }
}
