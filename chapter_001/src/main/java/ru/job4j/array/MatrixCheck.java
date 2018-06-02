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
        for (int j = 0; j < data.length - 1; j++) {
            if (data[0][0] != data[j + 1][j + 1]) {
                result = false;
                break;
            } else if (data[j][data.length - 1 - j] != data[j + 1][data.length - 2 - j]) {
                result = false;
                break;
            }
        }

        return result;
    }
}
