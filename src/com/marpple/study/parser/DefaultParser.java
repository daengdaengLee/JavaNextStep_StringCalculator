package com.marpple.study.parser;

import java.util.Arrays;
import java.util.List;

public class DefaultParser implements IParser {
    private final String expression;
    private List<Integer> numbers = null;

    DefaultParser(String expression) {
        this.expression = expression;
    }

    @Override
    public void parse() {
        this.numbers = Arrays.stream(this.expression.split("[,:]"))
                .map(Integer::valueOf)
                .toList();
    }

    @Override
    public List<Integer> getParsedValue() {
        if (this.numbers == null) {
            throw new RuntimeException("parse 메소드를 아직 실행하지 않았습니다. 먼저 parse 메소드를 실행해주세요.");
        }
        return this.numbers;
    }
}
