package ru.job4j.array;

/**
 * Квадратный массив заполнен true или false по диагоналям.
 *
 * @author Ruslan.Topolskiy (ruslan.topolskiy@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class MatrixCheck {

    /**
     * Metod boolean
     *
     * @param data
     * @return
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length -1; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (data[i][j] != data[i + 1][j + 1]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
