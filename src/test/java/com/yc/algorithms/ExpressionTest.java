package com.yc.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpressionTest {

    @Test
    @DisplayName("Test \"(1 + 2) * 4 = 12\"")
    public void testIsExpressionBalanced() {
        Expression expression = new Expression("(1 + 2) * 4 = 12");
        assertTrue(expression.isBalanced());
    }
}
