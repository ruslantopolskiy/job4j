package ru.job4j.array;

/**
 * Двухмерный массив. Таблица умножения.
 *
 * @author Ruslan Topolskiy(ruslan.topolskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {

    /**
     * Metod multiple
     *
     * @param size
     * @return
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
