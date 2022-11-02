/*
Author: J. Kuehne
Date: 12.10.2022
Lecture: AnD
Project: Exercise 3
Summary:
    This file is used to show the correctness of the algorithm in 3.5 e).
*/

public class IterativeSquaring {
    public static void main(String[] args) {
        // take input
        int a = 4;
        int n = 11;
        // give output
        System.out.println(a + "^" + n + " = " + potence(a, n));
    }

    public static int potence(int a, int n) {
        // base case 1
        if (n == 0) {
            return 1;
        }

        // base case 2
        if (n == 1) {
            return a;
        }

        // base 3
        if (n == 2) {
            return a * a;
        }

        // odd potence
        if (n % 2 == 1) {
            int k = potence(a, n / 2);
            return a * k * k;
        
        // even potence
        } else {
            int k = potence(a, n / 2);
            return k * k;
        }
    }
}
