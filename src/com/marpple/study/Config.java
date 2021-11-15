package com.marpple.study;

public class Config {
    private final String expression;

    Config(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("잘못된 실행입니다. args 의 길이가 1 이 아닙니다.");
        }
        this.expression = args[0];
    }

    public String getExpression() {
        return this.expression;
    }
}
