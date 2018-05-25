package ru.job4j.loop;

/**
 * Вычесляем факториал.
 */
public class Factorial {

    /**
     * .
     * Metod calc.
     *
     * @param n .
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
