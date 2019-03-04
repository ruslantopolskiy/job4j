package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class StreamTest {
    Stream stream = new Stream();

    @Test
    public void whenDigitStreamEvenThenTrue() {
        assertTrue(stream.replace(2));
    }

    @Test
    public void whenDigitStreamOddThenFalse() {
        assertFalse(stream.replace(111));
    }

    @Test
    public void whenDigitStreamEmptyThenFalse() {
        assertFalse(stream.isNumber(InputStream.nullInputStream()));
    }

    @Test
    public void whenDigitStreamTextThenFalse() {
        String text = "Hello world!";
        byte[] buffer = text.getBytes();
        assertFalse(stream.isNumber(new ByteArrayInputStream(buffer)));
    }
}