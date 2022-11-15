package ex8;

import java.util.Stack;

/*
Author: J. Kuehne
Date: 15.11.2022
Lecture: AnD
Project: Exercise 8
Summary:
    This file is used to show the correctness of the algorithm in 8.4.
*/

public class Brackets {
    public static void main(String[] args) {
        String s = "(a(b(c[d])))";
        // create stack
        Stack<Character> brackets = new Stack<>();

        // go through string
        for (int i = 0; i < s.length(); ++i) {
            // get current char => imagine check if in alphabet
            char current = s.charAt(i);
            // new open square bracket
            if (current == '[') {
                brackets.push('[');
            // close square bracket
            } else if (current == ']') {
                // check if last square bracket
                if (brackets.isEmpty() || !(brackets.pop() == '[')) {
                    // illegal
                    System.out.println("not valid");
                    System.exit(-1);
                }
            // new open round bracket
            } else if (current == '(') {
                brackets.push('(');
            // close round bracket
            } else if (current == ')') {
                // check if last round bracket
                if (brackets.isEmpty() || !(brackets.pop() == '(')) {
                    // illegal
                    System.out.println("not valid");
                    System.exit(-1);
                }
            }
        }

        // check for remainder
        if (!brackets.isEmpty()) {
            System.out.println("not valid");
        } else {
            System.out.println("valid");
        }
    }


}
