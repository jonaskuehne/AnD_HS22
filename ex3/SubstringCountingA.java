package ex3;

/*
Author: J. Kuehne
Date: 12.10.2022
Lecture: AnD
Project: Exercise 3
Summary:
    This file is used to show the correctness of the algorithm in 3.2 a).
*/

import java.util.*;

public class SubstringCountingA {
    public static void main(String[] args) {
        // input
        String mainString = "0100101";
        // number of ones per substring
        int k = 2;

        // later use in for loops
        int length = mainString.length();


        // check if input valid
        for (char input : mainString.toCharArray()) {
            if (input != '0' && input !='1') {
                System.out.println("Input no bitstring!");
                System.exit(0);
            }
        }

        // print info
        System.out.println("String: " + mainString);

        // counter
        int count = 0;

        // to store substrings, list instead of array for convenience
        List<String> subStringList = new ArrayList<String>();

        // O(n²)
        // iterate through possible starts, - 1 to prevent empty strings
        for (int start = 0; start < length - 1; ++start){
            // iterate through possible ends, + 1 to prevent empty strings
            for (int end = start + 1; end < length + 1; ++ end){
                // add to list
                subStringList.add(mainString.substring(start, end));
            }
        }

        // O(n³)
        // iterate through substrings
        for (String subString : subStringList){
            // convert to char array
            char[] subStringChar = subString.toCharArray();
            // counter for ones in string
            int numOnes = 0;
            // iterate through string (char array)
            for (char possOne : subStringChar){
                // is one -> increase count
                if (possOne == '1'){
                    ++numOnes;
                }
            }
            // substring has desired number of ones
            if (numOnes == k){
                ++count;
                System.out.println("valid: " + subString);
            }
        }

        System.out.println("Number of substrings containing " + k + " ones: " + count);

    }
}
