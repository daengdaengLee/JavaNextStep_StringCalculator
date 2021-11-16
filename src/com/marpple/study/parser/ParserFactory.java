package com.marpple.study.parser;

public class ParserFactory {
    public static IParser makeParser(String expression) {
        if (expression.isBlank()) {
            return new EmptyParser(expression);
        }

        if (expression.startsWith("//")) {
            return new CustomParser(expression);
        }

        return new DefaultParser(expression);
    }
}
