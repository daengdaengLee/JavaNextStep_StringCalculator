package com.marpple.study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    public void 빈_문자열을_입력하면_0을_반환한다() {
        String expression = "";
        int expected = 0;
        int actual = new StringCalculator(expression).run();
        assertEquals(expected, actual);
    }

    @Test
    public void 공백만_있는_문자열을_입력하면_0을_반환한다() {
        int len = new Random().nextInt(1, 11);
        char[] spaces = new char[len];
        Arrays.fill(spaces, ' ');
        String expression = new String(spaces);
        int expected = 0;
        int actual = new StringCalculator(expression).run();
        assertEquals(expected, actual);
    }

    @Test
    public void 쉼표로_구분된_음이_아닌_정수들의_문자열을_입력하면_모든_정수를_더한_값을_반환한다() {
        int len = new Random().nextInt(1, 11);
        int[] numbers = IntStream.range(0, len).map((int i) -> new Random().nextInt(0, 100)).toArray();
        String expression = Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.joining(","));
        int expected = Arrays.stream(numbers).sum();
        int actual = new StringCalculator(expression).run();
        assertEquals(expected, actual);
    }

    @Test
    public void 음의_정수가_포함될_때_쉼표로_구분된_정수들의_문자열을_입력하면_런타임_에러를_발생시킨다() {
        Random rand = new Random();
        int len = rand.nextInt(1, 11);
        int negative_idx = rand.nextInt(0, len);
        int[] numbers = IntStream.range(0, len).map((int i) -> new Random().nextInt(0, 100)).toArray();
        numbers[negative_idx] *= -1;
        final String expression = Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.joining(","));
        assertThrows(RuntimeException.class, new StringCalculator(expression)::run);
    }

    @Test
    public void 콜론으로_구분된_음이_아닌_정수들의_문자열을_입력하면_모든_정수를_더한_값을_반환한다() {
        int len = new Random().nextInt(1, 11);
        int[] numbers = IntStream.range(0, len).map((int i) -> new Random().nextInt(0, 100)).toArray();
        String expression = Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.joining(":"));
        int expected = Arrays.stream(numbers).sum();
        int actual = new StringCalculator(expression).run();
        assertEquals(expected, actual);
    }
}