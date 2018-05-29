package ru.job4j.array;

/**
 * Массив заполнен true или false.
 *
 * @author Ruslan Topolskiy(ruslan.topolskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {

    /**
     * Metod indexOf.
     *
     * @param data .
     * @return Возвращает true или false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
