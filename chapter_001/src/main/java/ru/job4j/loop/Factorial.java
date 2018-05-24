package ru.job4j.loop;

/**
 * Вычесляем факториал.
 */
public class Factorial {

    /**
     * .
     * Metod calc.
     *
     * @param n  .
     */
    public int calc(int n) {
        int result = 1;
        if (n == 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
