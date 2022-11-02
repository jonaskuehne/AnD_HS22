/*
Author: J. Kuehne
Date: 12.10.2022
Lecture: AnD
Project: Exercise 3
Summary:
    This file is used to show the correctness of the algorithm in 3.2 d).
*/

public class SubstringCountingD {

    public static void main(String[] args) {
        // take input
        String mainString = "0100101";
        // save for later
        int n = mainString.length();
        // number of ones
        int k = 2;

        // vars for storage
        int out = 0;
        int count = 0;

        // storage for prefix
        int[] table = new int[n + 1];
        // init
        table[0] = 1;
        // for convenience
        char[] mainArray = mainString.toCharArray();

        // iterate over n -> O(n)
        for (int i = 0; i < n; ++i) {
            // update sum with 1 or 0
            count += Character.getNumericValue(mainArray[i]);

            // reached desired number of ones
            if (count >= k) {
                // found -> add
                out += table[count - k];
            }

            // update
            ++table[count];
        }

        // print infos
        System.out.println("String: " + mainString);
        System.out.println("Number of substrings containing " + k + " ones: " + out);

    }

}
