package com.marpple.study;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    public void 빈_문자열을_입력하면_0을_반환한다() {
        String expression = "";
        int expected = 0;
        int actual = new StringCalculator(expression).run();
        assertEquals(expected, actual);
    }
}