package com.marpple.study.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class DefaultParserTest {
    @Test
    public void 쉼표로_구분된_정수들의_문자열을_입력하면_나온_순서대로_정렬된_정수들의_리스트를_반환한다() {
        Random rand = new Random();
        Integer[] expected = IntStream.range(0, rand.nextInt(1, 11))
                .map((int i) -> rand.nextInt(-100, 100))
                .boxed()
                .toArray(Integer[]::new);
        String expression = Arrays.stream(expected)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        IParser parser = new DefaultParser(expression);
        parser.parse();
        Integer[] actual = parser.getParsedValue().toArray(Integer[]::new);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void 콜론으로_구분된_정수들의_문자열을_입력하면_나온_순서대로_정렬된_정수들의_리스트를_반환한다() {
        Random rand = new Random();
        Integer[] expected = IntStream.range(0, rand.nextInt(1, 11))
                .map((int i) -> rand.nextInt(-100, 100))
                .boxed()
                .toArray(Integer[]::new);
        String expression = Arrays.stream(expected)
                .map(String::valueOf)
                .collect(Collectors.joining(":"));
        IParser parser = new DefaultParser(expression);
        parser.parse();
        Integer[] actual = parser.getParsedValue().toArray(Integer[]::new);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void 다른_구분자로_구분된_정수들의_문자열을_입력하면_에러를_던진다() {
        Random rand = new Random();
        String expression = IntStream.range(0, rand.nextInt(1, 11))
                .map((int i) -> rand.nextInt(-100, 100))
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(";"));
        Class<RuntimeException> expected = RuntimeException.class;
        Executable actual = () -> {
            IParser parser = new DefaultParser(expression);
            parser.parse();
            parser.getParsedValue();
        };
        assertThrows(expected, actual);
    }

    @Test
    public void parse_메소드를_실행하기_전에_getParsedValue_메소드를_실행하면_에러를_던진다() {
        Random rand = new Random();
        String expression = IntStream.range(0, rand.nextInt(1, 11))
                .map((int i) -> rand.nextInt(-100, 100))
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        Class<RuntimeException> expected = RuntimeException.class;
        Executable actual = () -> {
            IParser parser = new DefaultParser(expression);
            parser.getParsedValue();
        };
        assertThrows(expected, actual);
    }
}