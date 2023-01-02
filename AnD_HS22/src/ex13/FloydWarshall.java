package ex13;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

/*
Author: J. Kuehne
Date: 19.12.2022
Lecture: AnD
Project: Exercise 13
Summary:
    This file is used to keep me sane.
*/

public class FloydWarshall {

    public static void main(String[] args) throws FileNotFoundException{
        // get input graph
        Scanner in = new Scanner(new File("AnD_HS22/src/ex13/graph.in"));
        int n = in.nextInt();
        ArrayList<Edge> graph = getGraph(in);

        // init
        int[][] curr = new int[n][n];
        // int[][] last = new int[n][n];
        // not reachable
        for (int i = 0; i < n; ++i) {
            Arrays.fill(curr[i], Integer.MAX_VALUE);
        }
        // diagonal
        for (int i = 0; i < n; ++i) {
            curr[i][i] = 0;
        }
        // directly reachable
        for (Edge e : graph) {
            curr[e.from][e.to] = e.cost;
        }

        // print state
        System.out.println("i = 0");
        printGraph(curr);

        // dp
        // index vertices
        for (int i = 0; i < n; ++i) {
            // copy
            for (int k = 0; k < n; ++k) {
            //    last[k] = curr[k].clone();
            }
            // from
            for (int x = 0; x < n; ++x) {
                // to
                for (int y = 0; y < n; ++y) {
                    // get sum
                    int sum = curr[x][i] + curr[i][y];
                    if (curr[x][i] == Integer.MAX_VALUE || curr[i][y] == Integer.MAX_VALUE) {
                        sum = Integer.MAX_VALUE;
                    }
                    // prevent overflow
                    curr[x][y] = Math.min(curr[x][y], sum);
                }
            }
            // print
            System.out.println("i = " + (i + 1));
            printGraph(curr);
        }
    }


    // gets us graph representation
    public static ArrayList<Edge> getGraph(Scanner in) {
        // number of edges
        int m = in.nextInt();
        // list for storing
        ArrayList<Edge> graph = new ArrayList<>();

        // add edges
        for (int i = 0; i < m; ++i) {
            graph.add(new Edge(in.nextInt(), in.nextInt(), in.nextInt()));
        }

        return graph;
    }

    // prints graph
    public static void printGraph(int[][] graph) {
        System.out.println();
        for (int i = 0; i < graph.length; ++i) {
            for (int j = 0; j < graph[i].length; ++j) {
                if (graph[i][j] == Integer.MAX_VALUE) {
                    System.out.print("~ ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}

// class for edges
class Edge {
    // class vars
    int from;
    int to;
    int cost;
    // ctors
    public Edge(int from, int to, int cost) {
      // set stuff
      this.from = from;
      this.to = to;
      this.cost = cost;
    }
}
