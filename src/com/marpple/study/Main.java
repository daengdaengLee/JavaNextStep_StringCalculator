package com.marpple.study;

public class Main {

    public static void main(String[] args) {
        Config config;
        try {
            config = new Config(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            return;
        }

        StringCalculator calculator = new StringCalculator(config.getExpression());
        int result = calculator.run();
        System.out.println("결과 : " + result);
    }
}
