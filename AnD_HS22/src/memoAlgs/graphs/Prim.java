package memoAlgs.graphs;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file implements Prims algorithm.
*/

public class Prim {

    // used for its original purpose (MST)
    public static List<Edge> mst(ArrayList<ArrayList<Edge>> graph, int start) {
        int n = graph.size();
        // store distances
        int[] d = new int[n];
        // init
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        // store used edges
        List<Edge> mstEdges = new ArrayList<>();

        // create heap
        PriorityQueue<Edge> heap = new PriorityQueue<>();
        // add first element
        heap.add(new Edge(start, start, 0));
        // keep track of added vertices
        boolean[] done = new boolean[n];
        int numAdded = 0;

        // until all added
        while (numAdded < n && !heap.isEmpty()) {
            // get element
            Edge e = heap.poll();
            // add to list, weight no longer accurate but who cares
            // skip first one
            if (e.from != e.to) {
                mstEdges.add(e);
            }
            // mark
            done[e.to] = true;
            ++numAdded;
            // adjust
            for (Edge next : graph.get(e.to)) {
                // not done yet
                if (!done[next.to]) {
                    // adjust distance
                    d[next.to] = Math.min(d[next.to], next.cost);
                    // yeet into heap
                    // could be removed before, but needs O(n)...
                    heap.add(new Edge(next.from, next.to, d[next.to]));
                }
            }
        }

        return mstEdges;
    }
}
