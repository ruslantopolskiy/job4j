package ru.job4j.array;

/**
 * Test
 *
 * @author Ruslan Topolskiy(ruslan.topolskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    //тест, проверяющий переворот массива с нечётным числом элементов.
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] result = turner.turn(input);
        int[] expect = new int[]{5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }

    @Test
    //тест, проверяющий переворот массива с чётным числом элементов.
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{2, 3, 4, 5};
        int[] result = turner.turn(input);
        int[] expect = new int[]{5, 4, 3, 2};
        assertThat(result, is(expect));
    }
}