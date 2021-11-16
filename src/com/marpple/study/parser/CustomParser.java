package com.marpple.study.parser;

import java.util.Arrays;
import java.util.List;

public class CustomParser implements IParser {
    private final String expression;
    private List<Integer> numbers = null;

    CustomParser(String expression) {
        this.expression = expression;
    }

    @Override
    public void parse() {
        String expSep = "\n";
        int idx = this.expression.indexOf(expSep);
        String head = this.expression.substring(0, idx);
        String tail = this.expression.substring(idx + expSep.length());
        String sep = head.substring("//".length());
        this.numbers = Arrays.stream(tail.split("[" + sep + "]"))
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
