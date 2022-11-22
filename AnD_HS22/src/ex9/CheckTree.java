package ex9;

import java.util.LinkedList;

/*
Author: J. Kuehne
Date: 22.11.2022
Lecture: AnD
Project: Exercise 9
Summary:
    This file is used to show the correctness of the algorithm in 9.5 d).
*/

public class CheckTree {
    public static void main(String[] args) {
        // input1
        int[][] E1 = {{1, 3}, {6, 1}, {3, 5}, {2, 3}, {4, 1}};
        int n1 = 6;
        // input 2
        int[][] E2 = {{1, 3}, {4, 5}, {5, 2}, {2, 4}};
        int n2 = 5;

        // output1
        System.out.print("Graph 1: ");
        if (isTree(E1, n1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        // output 2
        System.out.print("Graph 2: ");
        if (isTree(E2, n2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    // checks if graph is tree, m from task is E.length
    // checks edge condition and if graph is connected
    public static boolean isTree(int[][] E, int n) {
        // edge condition
        if (E.length != n - 1) {
            return false;
        }

        // list for saving reachable vertices
        LinkedList<Integer> vertexList = new LinkedList<Integer>();
        // add first one
        vertexList.add(E[0][0]);

        // go through edges
        for (int i = 0; i < E.length; ++i) {
            // first vertex in?
            if (vertexList.contains(E[i][0])) {
                // second one not already in?
                if (!vertexList.contains(E[i][1])) {
                    // add
                    vertexList.add(E[i][1]);
                }
            // second vertex in?
            } else if (vertexList.contains(E[i][1])) {
                // first one not already in?
                if (!vertexList.contains(E[i][0])) {
                    // add
                    vertexList.add(E[i][0]);
                }
            }
        }

        // all vertices reachable?
        // checks connectivity condition
        if (vertexList.size() == n) {
            return true;
        } else {
            return false;
        }
    }
}
