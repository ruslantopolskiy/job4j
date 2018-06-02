package ru.job4j.array;

/**
 * Программа переворачивающая массив.
 *
 * @author Ruslan Topolskiy(ruslan.topolskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Turn {

    /**
     * Metode turn.
     *
     * @param array Исходный массив.
     * @return Перевёрнутый массив.
     */
    public int[] turn(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int a = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = a;
        }
        return array;
    }
}
