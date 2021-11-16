package com.marpple.study;

import java.util.List;

public class ApplicationRunner {
    public static void run(Config config) {
        List<Integer> numbers = ExpressionParser.parse(config.getExpression());
        int sum = numbers.stream().mapToInt((Integer a) -> a).sum();
        System.out.println("결과 : " + sum);
    }
}
