package com.yc.algorithms;

import java.util.Stack;

public class StringReverser {

    public static String reverseWithStack(String str) {
        if (str == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray())
            stack.push(c);

        StringBuilder sb = new StringBuilder();
        while (!stack.empty())
            sb.append(stack.pop());

        return sb.toString();
    }
}
