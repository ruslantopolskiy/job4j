package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    private int[] numbers;
    private int count = 0;

    public EvenIterator(final int[] numbers) {
        this.numbers = numbers;
    }


    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int index = count; index < numbers.length; index++) {
            if (numbers[index] % 2 == 0) {
                result = true;
                count = index;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (numbers[count] % 2 != 0) {
            count++;
        }
        return numbers[count++];
    }

}
