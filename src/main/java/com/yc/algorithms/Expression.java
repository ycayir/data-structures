package com.yc.algorithms;

import java.util.Stack;

public class Expression {
    private String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public boolean isBalanced() {
        char openingParenthesis = '(';
        char closingParanthesis = ')';

        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (openingParenthesis == c) {
                stack.push(c);
            }

            if (closingParanthesis == c) {
                stack.pop();
            }
        }

        return stack.empty();
    }
}
