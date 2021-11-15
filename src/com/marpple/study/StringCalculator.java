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

        if (this.expression.startsWith("//")) {
            String expSep = "\n";
            int idx = this.expression.indexOf(expSep);
            String head = this.expression.substring(0, idx);
            String tail = this.expression.substring(idx + expSep.length());
            String sep = head.substring("//".length());
            return Arrays.stream(tail.split("[" + sep + "]")).mapToInt(Integer::valueOf).peek(num -> {
                if (num < 0) {
                    throw new RuntimeException("음의 정수가 포함된 문자열은 처리할 수 없습니다.");
                }
            }).sum();
        }

        return Arrays.stream(this.expression.split("[,:]")).mapToInt(Integer::valueOf).peek(num -> {
            if (num < 0) {
                throw new RuntimeException("음의 정수가 포함된 문자열은 처리할 수 없습니다.");
            }
        }).sum();
    }
}
