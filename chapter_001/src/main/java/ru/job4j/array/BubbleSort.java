package ru.job4j.array;

/**
 * Создать программу для сортировки массива методом перестановки.
 *
 * @author Ruslan Topolskiy(ruslan.topolskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {

    /**
     * Metod sort .
     *
     * @param array .
     * @return Возвращает сортированный массив.
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int index = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = index;
                }
            }
        }
        return array;
    }
}
