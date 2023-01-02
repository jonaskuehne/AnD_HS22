package memoAlgs.graphs;

import java.util.Scanner;
import java.util.ArrayList;
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
        Scanner in = new Scanner(new File("AnD_HS22/src/memoAlgs/graphs/graphWcycle.in"));
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        GetGraph.getDirGraphAdjList(in, graph);
        System.out.println(DFS.hasCycle(graph));

        // BFS
    }
}
