package com.marpple.study;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("잘못된 실행입니다.");
            System.exit(1);
            return;
        }

        StringCalculator calculator = new StringCalculator(args[0]);
        int result = calculator.run();
        System.out.println("결과 : " + result);
    }
}
