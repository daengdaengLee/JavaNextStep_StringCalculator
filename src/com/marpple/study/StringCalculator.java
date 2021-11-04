package com.marpple.study;

import java.util.Arrays;

public class StringCalculator {
    private final String expression;

    StringCalculator(String expression) {
        this.expression = expression;
    }

    public int run() {
        if (this.expression.isBlank()) {
            return 0;
        }

        return Arrays.stream(this.expression.split(",")).mapToInt(Integer::valueOf).sum();
    }
}
