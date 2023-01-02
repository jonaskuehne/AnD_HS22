package memoAlgs.graphs;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Scanner;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file reads graph from input file.
*/

public class GetGraph {

    // get graph edges
    public static void getGraphEdges(Scanner in, Collection<Edge> graph) {
        // number of edges
        int m = in.nextInt();

        // add edges
        for (int i = 0; i < m; ++i) {
            graph.add(new Edge(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }

    // get adj. list unweighted
    public static void getGraphAdjList(Scanner in, 
            ArrayList<ArrayList<Integer>> graph) {
        // number of vertices
        int n = in.nextInt();
        // number of edges
        int m = in.nextInt();
        
        // prepare
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        // add edges
        for (int i = 0; i < m; ++i) {
            graph.get(in.nextInt()).add(in.nextInt());
        }
    }

    // get adj. list weighted
    public static void getEdgeGraphAdjList(Scanner in, 
            ArrayList<ArrayList<Edge>> graph) {
        // number of vertices
        int n = in.nextInt();
        // number of edges
        int m = in.nextInt();
        
        // prepare
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        // add edges
        for (int i = 0; i < m; ++i) {
            int from = in.nextInt();
            int to = in.nextInt();
            int cost = in.nextInt();
            graph.get(from).add(new Edge(from, to, cost));
        }
    }

}
