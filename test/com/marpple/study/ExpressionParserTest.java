package com.marpple.study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionParserTest {
    @Test
    public void 빈_문자열을_입력하면_빈_리스트를_반환한다() {
        String expression = "";
        int expected = 0;
        int actual = ExpressionParser.parse(expression).size();
        assertEquals(expected, actual);
    }

    @Test
    public void 공백만_있는_문자열을_입력하면_빈_리스트를_반환한다() {
        Random rand = new Random();
        String expression = IntStream.range(0, rand.nextInt(1, 11))
                .mapToObj((int i) -> "")
                .collect(Collectors.joining(""));
        int expected = 0;
        int actual = ExpressionParser.parse(expression).size();
        assertEquals(expected, actual);
    }

    @Test
    public void 쉼표로_구분된_음이_아닌_정수들의_문자열을_입력하면_나온_순서대로_정렬된_정수들의_리스트를_반환한다() {
        Random rand = new Random();
        Integer[] expected = IntStream.range(0, rand.nextInt(1, 11))
                .map((int i) -> rand.nextInt(0, 100))
                .boxed()
                .toArray(Integer[]::new);
        String expression = Arrays.stream(expected)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        Integer[] actual = ExpressionParser.parse(expression).toArray(Integer[]::new);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void 음의_정수가_포함될_때_쉼표로_구분된_정수들의_문자열을_입력하면_런타임_에러를_발생시킨다() {
        Random rand = new Random();
        Stream<Integer> posStream1 = IntStream.range(0, rand.nextInt(1, 10))
                .map((int i) -> rand.nextInt(0, 100))
                .boxed();
        Stream<Integer> posStream2 = IntStream.range(0, rand.nextInt(1, 10))
                .map((int i) -> rand.nextInt(0, 100))
                .boxed();
        Stream<Integer> negStream = IntStream.range(0, rand.nextInt(1, 10))
                .map((int i) -> rand.nextInt(-100, 0))
                .boxed();
        String expression = Stream.concat(Stream.concat(posStream1, negStream), posStream2)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        Class<RuntimeException> expected = RuntimeException.class;
        Executable actual = () -> ExpressionParser.parse(expression);
        assertThrows(expected, actual);
    }

    @Test
    public void 콜론으로_구분된_음이_아닌_정수들의_문자열을_입력하면_나온_순서대로_정렬된_정수들의_리스트를_반환한다() {
        Random rand = new Random();
        Integer[] expected = IntStream.range(0, rand.nextInt(1, 11))
                .map((int i) -> rand.nextInt(0, 100))
                .boxed()
                .toArray(Integer[]::new);
        String expression = Arrays.stream(expected)
                .map(String::valueOf)
                .collect(Collectors.joining(":"));
        Integer[] actual = ExpressionParser.parse(expression).toArray(Integer[]::new);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void 음의_정수가_포함될_때_콜론으로_구분된_정수들의_문자열을_입력하면_런타임_에러를_발생시킨다() {
        Random rand = new Random();
        Stream<Integer> posStream1 = IntStream.range(0, rand.nextInt(1, 10))
                .map((int i) -> rand.nextInt(0, 100))
                .boxed();
        Stream<Integer> posStream2 = IntStream.range(0, rand.nextInt(1, 10))
                .map((int i) -> rand.nextInt(0, 100))
                .boxed();
        Stream<Integer> negStream = IntStream.range(0, rand.nextInt(1, 10))
                .map((int i) -> rand.nextInt(-100, 0))
                .boxed();
        String expression = Stream.concat(Stream.concat(posStream1, negStream), posStream2)
                .map(String::valueOf)
                .collect(Collectors.joining(":"));
        Class<RuntimeException> expected = RuntimeException.class;
        Executable actual = () -> ExpressionParser.parse(expression);
        assertThrows(expected, actual);
    }

    @Test
    public void 세미콜론_커스텀_구분자로_구분된_음이_아닌_정수들의_문자열을_입력하면_나온_순서대로_정렬된_정수들의_리스트를_반환한다() {
        Random rand = new Random();
        Integer[] expected = IntStream.range(0, rand.nextInt(1, 11))
                .map((int i) -> rand.nextInt(0, 100))
                .boxed()
                .toArray(Integer[]::new);
        String expression = Arrays.stream(expected)
                .map(String::valueOf)
                .collect(Collectors.joining(";"));
        expression = "//;\n" + expression;
        Integer[] actual = ExpressionParser.parse(expression).toArray(Integer[]::new);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void 음의_정수가_포함될_때_세미콜론_커스텀_구분자로_구분된_정수들의_문자열을_입력하면_런타임_에러를_발생시킨다() {
        Random rand = new Random();
        Stream<Integer> posStream1 = IntStream.range(0, rand.nextInt(1, 10))
                .map((int i) -> rand.nextInt(0, 100))
                .boxed();
        Stream<Integer> posStream2 = IntStream.range(0, rand.nextInt(1, 10))
                .map((int i) -> rand.nextInt(0, 100))
                .boxed();
        Stream<Integer> negStream = IntStream.range(0, rand.nextInt(1, 10))
                .map((int i) -> rand.nextInt(-100, 0))
                .boxed();
        String expression = "//;\n" + Stream.concat(Stream.concat(posStream1, negStream), posStream2)
                .map(String::valueOf)
                .collect(Collectors.joining(";"));
        Class<RuntimeException> expected = RuntimeException.class;
        Executable actual = () -> ExpressionParser.parse(expression);
        assertThrows(expected, actual);
    }
}