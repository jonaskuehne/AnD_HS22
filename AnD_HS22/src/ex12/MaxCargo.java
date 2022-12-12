package ex12;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
Author: J. Kuehne
Date: 12.12.2022
Lecture: AnD
Project: Exercise 12
Summary:
    This file is used to show the correctness of the algorithm in 12.2 d).
    Implements spanning tree stuff by itself for good measure
*/

public class MaxCargo {

    public static void main(String[] args) throws FileNotFoundException{
        // get input graph
        Scanner in = new Scanner(new File("AnD_HS22/src/ex12/graph.in"));
        int n = in.nextInt();
        ArrayList<Edge> graph = getGraph(in);
        int start = 0;

        // get max spanning tree and change to adj. list
        ArrayList<ArrayList<Edge>> maxSpanTree = toAdjList(n, 
                getMaxSpanTree(n, graph));

        // arrays to track progress
        boolean[] visited = new boolean[n];
        int[] maxCargo = new int[n];
        Arrays.fill(maxCargo, Integer.MAX_VALUE);

        // queue for bfs
        Queue<Integer> queue = new LinkedList<>();
        // init value
        queue.add(start);

        // bfs
        while (!queue.isEmpty()) {
            // get element
            int u = queue.remove();
            // mark
            visited[u] = true;
            // go through next ones
            for (Edge e : maxSpanTree.get(u)) {
                // not visited yet
                if (!visited[e.to]) {
                    // enqueue
                    queue.add(e.to);
                    // get new bottleneck
                    maxCargo[e.to] = Math.min(e.cost, maxCargo[u]);
                }
            }
        }

        // print result
        for (int i = 0; i < maxCargo.length; ++i) {
            System.out.println("Max cargo from " + start + " to " + i + ": " + 
                    maxCargo[i]);
        }
    }

    // executes kruskal
    public static ArrayList<Edge> getMaxSpanTree(int n, ArrayList<Edge> graph) {
        // reps for vertices
        int[] rep = new int[n];
        // list of members
        ArrayList<ArrayList<Integer>> members = new ArrayList<>();
        // init
        for (int i = 0; i < rep.length; ++i) {
            // represents itself
            rep[i] = i;
            // list for members of subgraph
            members.add(new ArrayList<>());
            members.get(i).add(i);
        }

        // resulting tree
        ArrayList<Edge> maxSpanTree = new ArrayList<>();
        // go through edges, sorted in increasing order
        for (Edge e : graph) {
            // other subgraph?
            if (rep[e.from] != rep[e.to]) {
                // add edge
                maxSpanTree.add(e);
                // unite
                // which one is shorter?
                int from;
                int to;
                if (members.get(rep[e.from]).size() < 
                        members.get(rep[e.to]).size()) {
                    from = e.from;
                    to = e.to;
                } else {
                    from = e.to;
                    to = e.from;
                }
                // store old rep
                int oldRep = rep[from];
                // go through members
                for (int mem : members.get(oldRep)) {
                    // now also member
                    members.get(rep[to]).add(mem);
                    // change rep
                    rep[mem] = rep[to];
                }
    
                // because memoryflex
                members.set(oldRep, null);
            }
            // else ignore
        }
        

        return maxSpanTree;
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

        // sort -> e1 and e2 swapped for decreasing order.
        graph.sort(new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                return Integer.valueOf(e2.cost).compareTo(e1.cost);
            }
        });

        return graph;
    }

    // returns reorganized graph
    public static ArrayList<ArrayList<Edge>> toAdjList(int n, ArrayList<Edge> in) {
        // list for new graph
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        // init
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        // fill
        for (Edge e : in) {
            // add for undirected -> directed
            graph.get(e.from).add(new Edge(-1, e.to, e.cost));
            graph.get(e.to).add(new Edge(-1, e.from, e.cost));
        }

        return graph;
    }

}

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

    @Override
    public String toString() {
        return "from: " + from + ", to: " + to + ", with cost: " + cost;
    }
}