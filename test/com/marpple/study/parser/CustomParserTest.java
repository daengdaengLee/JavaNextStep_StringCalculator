package com.marpple.study.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CustomParserTest {
    @Test
    public void parse_메소드를_실행하기_전에_getParsedValue_메소드를_실행하면_에러를_던진다() {
        Random rand = new Random();
        String expression = "//;\n" + IntStream.range(0, rand.nextInt(1, 11))
                .map((int i) -> rand.nextInt(-100, 100))
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(";"));
        Class<RuntimeException> expected = RuntimeException.class;
        Executable actual = () -> {
            IParser parser = new CustomParser(expression);
            parser.getParsedValue();
        };
        assertThrows(expected, actual);
    }

    @Test
    public void 세미콜론_커스텀_구분자로_구분된_정수들의_문자열을_입력하면_나온_순서대로_정렬된_정수들의_리스트를_반환한다() {
        Random rand = new Random();
        Integer[] expected = IntStream.range(0, rand.nextInt(1, 11))
                .map((int i) -> rand.nextInt(-100, 100))
                .boxed()
                .toArray(Integer[]::new);
        String expression = "//;\n" + Arrays.stream(expected)
                .map(String::valueOf)
                .collect(Collectors.joining(";"));
        IParser parser = new CustomParser(expression);
        parser.parse();
        Integer[] actual = parser.getParsedValue().toArray(Integer[]::new);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void 다른_커스텀_구분자로_구분된_정수들의_문자열을_입력하면_에러를_던진다() {
        Random rand = new Random();
        String expression = "//_\n" + IntStream.range(0, rand.nextInt(1, 11))
                .map((int i) -> rand.nextInt(-100, 100))
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(";"));
        Class<RuntimeException> expected = RuntimeException.class;
        Executable actual = () -> {
            IParser parser = new CustomParser(expression);
            parser.parse();
            parser.getParsedValue();
        };
        assertThrows(expected, actual);
    }
}