package ru.job4j.comparable;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int size = left.length();
        if (left.length() < right.length()) {
            size = right.length();
        }
        char[] leftChar = massiveAll(left, size);
        char[] rightChar = massiveAll(right, size);

        int result = 0;
        for (int index = 0; index < size; index++) {
            if (Character.compare(leftChar[index], rightChar[index]) < 0) {
                result = -1;
                break;
            } else if (Character.compare(leftChar[index], rightChar[index]) > 0) {
                result = 1;
                break;
            }
        }
        return result;
    }

    public char[] massiveAll(String a, int size) {
        char[] result = new char[size];
        for (int index = 0; index < a.length(); index++) {
            result[index] = a.charAt(index);
        }
        return result;
    }

}