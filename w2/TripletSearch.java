/*
Author: J. Kuehne
Date: 05.10.2022
Lecture: AnD
Project: Exercise 2
Summary:
    This file is used to show the correctness of the algorithm in 2.5 b) and c).
*/
import java.util.*;
 
public class TripletSearch {
 
    public static void main(String[] args) {
        // input
        int src[] = {5, 10, 9, 1, 8, 0, 1, 1, 1, 1, 324};
        int t = 22;
        
        System.out.println("sum: " + t);

        searchTriplet(src, t);
    }

    static void searchTriplet(int src[], int sum) {
        // iterate over elements -> O(n²)
        for (int a = 0; a < src.length - 2; a++) {
            
            // hashset for storing
            HashSet<Integer> set = new HashSet<Integer>();
            // save
            int temp_sum = sum - src[a];
            // iterate over elements -> O(n)
            for (int b = 0; b < src.length; b++) {
                // contains a-b?
                if (set.contains(temp_sum - src[b])) {
                    // found
                    System.out.println("triplet " + src[a] + ", " +
                                      src[b] + ", " + (temp_sum - src[b]));
                    return;
                }
                // not found -> add
                set.add(src[b]);
            }
        }
 
        // gibt keine kombination
        System.out.println("no triplet found");
        return;
    }
}
