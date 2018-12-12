package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] result: array){
            for (Integer integer: result){
                list.add(integer);
            }
        }
     return list;
    }
}