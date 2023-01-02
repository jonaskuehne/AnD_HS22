package memoAlgs.graphs;

import java.util.ArrayList;
import java.util.Comparator;

/*
Author: J. Kuehne
Date: 02.01.2023
Lecture: AnD
Project: Exam Prep
Summary:
    This file implements Kruskals algorithm.
*/

public class Kruskal {

    // used for its original purpose (MST)
    public static ArrayList<Edge> mst(ArrayList<Edge> graph, int n) {
        // sort edges in inc. order
        graph.sort(new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                return Integer.valueOf(e1.cost).compareTo(e2.cost);
            }
        });

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
    
}
