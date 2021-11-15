package com.marpple.study;

public class ApplicationRunner {
    public static void run(Config config) {
        StringCalculator calculator = new StringCalculator(config.getExpression());
        int result = calculator.run();
        System.out.println("결과 : " + result);
    }
}
