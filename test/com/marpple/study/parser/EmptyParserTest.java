package com.marpple.study.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class EmptyParserTest {
    @Test
    void empty_문자열로_초기화한_경우_parse_메소드가_성공한다() {
        final String emptyString = "";

        Executable actual = () -> new EmptyParser(emptyString).parse();

        assertDoesNotThrow(actual);
    }

    @Test
    void blank_문자열로_초기화한_경우_parse_메소드가_성공한다() {
        final String blankString = "   ";

        Executable actual = () -> new EmptyParser(blankString).parse();

        assertDoesNotThrow(actual);
    }

    @Test
    void 다른_문자열로_초기화한_경우_parse_메소드에서_예외가_발생한다() {
        final String string = "123,456";

        Class<RuntimeException> expected = RuntimeException.class;
        Executable actual = () -> new EmptyParser(string).parse();

        assertThrows(expected, actual);
    }

    @Test
    void getParsedValue_메소드는_항상_빈_리스트를_반환한다() {
        IParser parser = new EmptyParser("");

        Integer[] expected = new Integer[0];
        Integer[] actual = parser.getParsedValue().toArray(Integer[]::new);

        assertArrayEquals(expected, actual);
    }
}