package com.marpple.study;

import java.util.stream.IntStream;

public class Calculator {
    public static int sumAll(IntStream numbers) {
        return numbers
                .peek((int num) -> {
                    if (num < 0) {
                        throw new RuntimeException("음의 정수가 포함된 문자열은 처리할 수 없습니다.");
                    }
                })
                .sum();
    }
}
