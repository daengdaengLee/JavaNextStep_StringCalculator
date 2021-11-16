package com.marpple.study;

import com.marpple.study.parser.IParser;
import com.marpple.study.parser.ParserFactory;

public class ApplicationRunner {
    public static void run(Config config) {
        IParser parser = ParserFactory.makeParser(config.getExpression());
        parser.parse();
        int sum = Calculator.sumAll(parser.getParsedValue().stream().mapToInt((Integer a) -> a));
        System.out.println("결과 : " + sum);
    }
}
