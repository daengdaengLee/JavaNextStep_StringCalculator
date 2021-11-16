package com.marpple.study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    @Test
    public void 음이_아닌_정수들의_스트림을_입력하면_모든_정수의_합을_반환한다() {
        Random rand = new Random();
        List<Integer> numbers = IntStream.range(0, rand.nextInt(1, 11))
                .map((int i) -> rand.nextInt(0, 100))
                .boxed()
                .toList();
        int expected = numbers.stream()
                .mapToInt((Integer a) -> a)
                .sum();
        int actual = Calculator.sumAll(numbers.stream().mapToInt((Integer a) -> a));
        assertEquals(expected, actual);
    }

    @Test
    public void 음의_정수가_포함된_정수들의_스트림을_입력하면_런타임_에러를_발생시킨다() {
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
        List<Integer> numbers = Stream.concat(Stream.concat(posStream1, negStream), posStream2).toList();
        Class<RuntimeException> expected = RuntimeException.class;
        Executable actual = () -> Calculator.sumAll(numbers.stream().mapToInt((Integer a) -> a));
        assertThrows(expected, actual);
    }
}