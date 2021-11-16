package com.marpple.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionParser {
    public static List<Integer> parse(String expression) {
        if (expression.isBlank()) {
            return new ArrayList<>();
        }

        if (expression.startsWith("//")) {
            String expSep = "\n";
            int idx = expression.indexOf(expSep);
            String head = expression.substring(0, idx);
            String tail = expression.substring(idx + expSep.length());
            String sep = head.substring("//".length());
            return Arrays.stream(tail.split("[" + sep + "]"))
                    .map(Integer::valueOf)
                    .peek(num -> {
                        if (num < 0) {
                            throw new RuntimeException("음의 정수가 포함된 문자열은 처리할 수 없습니다.");
                        }
                    })
                    .toList();
        }

        return Arrays.stream(expression.split("[,:]"))
                .map(Integer::valueOf)
                .peek(num -> {
                    if (num < 0) {
                        throw new RuntimeException("음의 정수가 포함된 문자열은 처리할 수 없습니다.");
                    }
                })
                .toList();
    }
}
