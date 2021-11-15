package com.marpple.study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {
    @Test
    public void 생성자에_길이가_0인_args를_전달하면_런타임_예외가_발생한다() {
        final String[] args = new String[0];
        assertThrows(RuntimeException.class, () -> {
            new Config(args);
        });
    }

    @Test
    public void 생성자에_길이가_1보다_큰_args를_전달하면_런타임_예외가_발생한다() {
        final String[] args = IntStream.range(0, new Random().nextInt(2, 10))
                .mapToObj((int i) -> IntStream.range(0, new Random().nextInt(1, 11)).map((int j) -> new Random().nextInt(0, 100)).toArray())
                .map((int[] numbers) -> Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.joining(";")))
                .toArray(String[]::new);
        assertThrows(RuntimeException.class, () -> {
            new Config(args);
        });
    }

    @Test
    public void 인자로_전달한_args의_첫번째_요소를_반환한다() {
        final String[] args = IntStream.range(0, 1)
                .mapToObj((int i) -> IntStream.range(0, new Random().nextInt(1, 11)).map((int j) -> new Random().nextInt(0, 100)).toArray())
                .map((int[] numbers) -> Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.joining(";")))
                .toArray(String[]::new);
        String expected = args[0];
        String actual = new Config(args).getExpression();
        assertEquals(expected, actual);
    }
}