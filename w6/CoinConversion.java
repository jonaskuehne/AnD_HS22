/*
Author: J. Kuehne
Date: 31.10.2022
Lecture: AnD
Project: Exercise 6
Summary:
    This file is used to show the correctness of the algorithm in 6.2 d).
*/

public class CoinConversion {
    public static void main(String[] args) {
        // input
        int n = 17;
        int[] b = {1, 9, 6};

        // computed "input"
        int[] f = new int[n];
        int k = b.length;

        // initialize f
        for (int i = 0; i < n; i++) {
            // "infinity"
            f[i] = Integer.MAX_VALUE;
        }

        // result -> n - 1 because start index 0
        int minNumCoins = otp_memo(n - 1, k, b, f);

        // output
        System.out.println("Minimal number of coins: " + minNumCoins);

    }

    // described method
    public static int otp_memo(int n, int k, int[] b, int[] f) {
        // base case -> -1 because start index 0
        if (n == -1) {
            return 0;
        }

        // already computed
        if (f[n] != Integer.MAX_VALUE) {
            return f[n];
        }
        
        // recursive case
        for (int coin = 0; coin < k; ++coin) {
            if (b[coin] <= n + 1) {
                f[n] = Math.min(f[n], 1 + otp_memo(n - b[coin], k, b, f));
            }
        }

        return f[n];
    }
}
