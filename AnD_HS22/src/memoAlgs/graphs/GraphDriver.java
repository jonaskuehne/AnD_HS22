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
        Scanner in = new Scanner(new File("AnD_HS22/src/memoAlgs/graphs/input/simpleGraph.in"));
        ArrayList<ArrayList<Integer>> simpleGraph = new ArrayList<>();
        GetGraph.getGraphAdjList(in, simpleGraph);
        System.out.println("DFS: has cycle: " + DFS.hasCycle(simpleGraph));
        System.out.println();
        
        // BFS, get shortest distances (use same graph)
        System.out.println("BFS: shortest distances in unweighted graph: " + Arrays.toString(BFS.shortestPaths(simpleGraph, 0)));
        System.out.println();

        // Dijkstra
        in = new Scanner(new File("AnD_HS22/src/memoAlgs/graphs/input/dijkstraGraph.in"));
        ArrayList<ArrayList<Edge>> dijkstraGraph = new ArrayList<>();
        GetGraph.getEdgeGraphAdjList(in, dijkstraGraph);
        System.out.println("Dijkstra: shortest distances in weighted graph: " + Arrays.toString(Dijkstra.shortestPaths(dijkstraGraph, 0)));
        System.out.println();

        // Bellman-Ford
        in = new Scanner(new File("AnD_HS22/src/memoAlgs/graphs/input/bellmanFordGraph.in"));
        int n = in.nextInt();
        ArrayList<Edge> bellmanFordGraph = new ArrayList<>();
        GetGraph.getGraphEdges(in, bellmanFordGraph);
        System.out.println("Bellman-Ford: shortest distances in weighted graph: " + Arrays.toString(BellmanFord.shortestPaths(bellmanFordGraph, 0, n)));
        System.out.println();

        // Prim
        in = new Scanner(new File("AnD_HS22/src/memoAlgs/graphs/input/mstGraph.in"));
        ArrayList<ArrayList<Edge>> primGraph = new ArrayList<>();
        GetGraph.getDirEdgeGraphAdjList(in, primGraph);
        System.out.println("MST with Prim: " + Prim.mst(primGraph, 0));
        System.out.println();

        // Kruskal (not really necessary if Prim possible...)
        in = new Scanner(new File("AnD_HS22/src/memoAlgs/graphs/input/mstGraph.in"));
        n = in.nextInt();
        ArrayList<Edge> kruskalGraph = new ArrayList<>();
        GetGraph.getGraphEdges(in, kruskalGraph);
        System.out.println("MST with Kruskal: " + Kruskal.mst(kruskalGraph, n));
        System.out.println();

        // Floyd-Warshall
        in = new Scanner(new File("AnD_HS22/src/memoAlgs/graphs/input/allPairsGraph.in"));
        n = in.nextInt();
        ArrayList<Edge> floydWarshallGraph = new ArrayList<>();
        GetGraph.getGraphEdges(in, floydWarshallGraph);
        System.out.println("Allpairs-Distance with Johnson: ");
        int[][] dF = FloydWarshall.shortestPath(floydWarshallGraph, n);
        for (int[] a : dF) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();

        // Johnson
        in = new Scanner(new File("AnD_HS22/src/memoAlgs/graphs/input/allPairsGraph.in"));
        n = in.nextInt();
        ArrayList<Edge> johnsonGraph = new ArrayList<>();
        GetGraph.getGraphEdges(in, johnsonGraph);
        System.out.println("Allpairs-Distance with Johnson: ");
        int[][] dJ = FloydWarshall.shortestPath(johnsonGraph, n);
        for (int[] a : dJ) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
    }
}
