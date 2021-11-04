package com.marpple.study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

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
}