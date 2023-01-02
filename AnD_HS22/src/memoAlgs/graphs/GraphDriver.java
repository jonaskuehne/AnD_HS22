package memoAlgs.graphs;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file shows the implementations of the graph algorithms.
*/

public class GraphDriver {
    public static void main(String[] args) throws FileNotFoundException {
        // DFS, check if graph has cycles
        Scanner in = new Scanner(new File("AnD_HS22/src/memoAlgs/graphs/simpleGraph.in"));
        ArrayList<ArrayList<Integer>> simpleGraph = new ArrayList<>();
        GetGraph.getGraphAdjList(in, simpleGraph);
        System.out.println("DFS: has cycle: " + DFS.hasCycle(simpleGraph));

        // BFS, get shortest distances (use same graph)
        System.out.println("BFS: shortest distances in unweighted graph: " + Arrays.toString(BFS.shortestPaths(simpleGraph, 0)));

        // Dijkstra
        in = new Scanner(new File("AnD_HS22/src/memoAlgs/graphs/dijkstra.in"));
        ArrayList<ArrayList<Edge>> dijkstraGraph = new ArrayList<>();
        GetGraph.getEdgeGraphAdjList(in, dijkstraGraph);
        System.out.println("Dijkstra: shortest distances in weighted graph: " + Arrays.toString(Dijkstra.shortestPaths(dijkstraGraph, 0)));


    }
}
