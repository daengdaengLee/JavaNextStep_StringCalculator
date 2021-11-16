package com.marpple.study.parser;

import java.util.ArrayList;
import java.util.List;

public class EmptyParser implements IParser {
    private final String expression;
    private final List<Integer> numbers = new ArrayList<>();

    EmptyParser(String expression) {
        this.expression = expression;
    }


    @Override
    public void parse() {
        if (!this.expression.isBlank()) {
            throw new RuntimeException("expression 이 blank 문자열이 아닙니다.");
        }
    }

    @Override
    public List<Integer> getParsedValue() {
        return this.numbers;
    }
}
