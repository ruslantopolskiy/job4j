package ru.job4j.max;
/**
 * Максимум 2 чисел.
 */
public class Max {

    /**
     * Вычесляем максимум из 2 чисел.
     * @param ferst первый аргумент.
     * @param second второй аргумент.
     * @return большее число.
     */
    public int max(int ferst, int second) {
        return ferst > second ? ferst : second;
    }

    /**
     * Вычесляем максимум из 3 чисел.
     * @param ferst первый аргумент.
     * @param second второй аргумент.
     * @param third третий аргумент.
     * @return большее число.
     */
    public int max(int ferst, int second, int third) {
        return (max(ferst, max(second, third)));
    }
}
