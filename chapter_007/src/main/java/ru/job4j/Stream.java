package ru.job4j;

import java.io.*;

/**
 * Реализовать сервис:
 * <p>
 * boolean isNumber(InputStream in);
 * <p>
 * Метод должен проверить, что в байтовом потоке записано четное число.
 * <p>
 * Все потоки должны быть обернуты через try-with-resources, даже, если это ByteArrayInputStream.
 */

public class Stream {
    public boolean isNumber(InputStream in) {
        boolean result = true;
        int lastIndex = -1;
        try {
            for (int i = in.read(); i != -1; i = in.read()) {
                if (i < 48 || i > 57) {
                    result = false;
                    break;
                }
                lastIndex = i;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result && lastIndex % 2 == 0;

    }

    public boolean replace(Integer integer) {
        byte[] buffer = integer.toString().getBytes();
        InputStream inputStream = new ByteArrayInputStream(buffer);
        return isNumber(inputStream);
    }
}
