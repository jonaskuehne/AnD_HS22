package memoAlgs.graphs;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file implements a class to represent edges in a graph.
*/

public class Edge implements Comparable<Edge> {
    int from;
    int to;
    int cost;

    // ctor
    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    // comparable
    public int compareTo(Edge other) {
        return Integer.compare(this.cost, other.cost);
    }

}
