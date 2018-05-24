package ru.job4j.loop;

/**
 * Вычесляем сумму четных числ от 1 до 10.
 */
public class Counter {

    /**.
     * Metod distanceTo.
     * @param start .
     *  @param finish .
     */
    public int add(int start, int finish){
        int a=0;
        for (int i=start;i<=finish;i++){
            if (i%2==0){
                a+=i;
            }
        }return a;
    }
}
