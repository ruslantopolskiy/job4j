package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayThenList() {
        ConvertList2Array list2Array = new ConvertList2Array();
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2, 3, 4});
        list.add(new int[]{5, 6, 7});
        List<Integer> result = list2Array.convert(list);
        List<Integer> finish = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThat(result, is(finish));
    }
}
