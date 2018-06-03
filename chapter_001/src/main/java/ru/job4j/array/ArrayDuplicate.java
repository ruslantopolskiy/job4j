package ru.job4j.array;

/**
 * 6.8. Удаление дубликатов в массиве.
 *
 * @author Ruslan Topolskiy(ruslan.topolskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import java.util.Arrays;

public class ArrayDuplicate {
    /**
     * Metod remove
     *
     * @param array
     * @return
     */
    public String[] remove(String[] array) {
        int count = array.length;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < count; j++) {
                if (array[i].equals(array[j])) {
                    String a = array[j];
                    array[j] = array[count - 1];
                    array[count - 1] = a;
                    count--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, count);
    }
}

