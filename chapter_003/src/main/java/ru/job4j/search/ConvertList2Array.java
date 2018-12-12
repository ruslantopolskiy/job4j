package ru.job4j.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int result = 0;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cells; y++) {
                if (result >= list.size()) {
                    break;
                } else {
                    array[x][y] = list.get(result);
                    result++;
                }
            }
        }
        return array;
    }


    public List<Integer> convert(List<int[]> list) {
        List<Integer> finish = new ArrayList<>();
        Iterator<int[]> iterator = list.iterator();
        while (iterator.hasNext()) {
            for (int value : iterator.next())
                finish.add(value);
        }
        return finish;
    }
}