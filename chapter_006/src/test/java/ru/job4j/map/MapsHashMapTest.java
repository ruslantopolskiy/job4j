package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;


public class MapsHashMapTest {
    MapsHashMap<User, String> mapsHashMap;
    private User first = new User(
            "Руслан",
            28,
            new GregorianCalendar(1990, 7, 18)
    );
    private User second = new User(
            "Леонид",
            18,
            new GregorianCalendar(2000, 3, 1)
    );

    private User three = new User(
            "Петр",
            40,
            new GregorianCalendar(1800, 2, 25)
    );

    private User four = new User(
            "Петр",
            40,
            new GregorianCalendar(1800, 2, 25)
    );

    @Before
    public void before() {
        mapsHashMap = new MapsHashMap();
    }

    @Test

    public void whenAddThreeElementsThenSizeThree() {
        mapsHashMap.insert(first, "Желтый");
        mapsHashMap.insert(second, "Зеленый");
        mapsHashMap.insert(three, "Огненный");
        assertThat(this.mapsHashMap.size(), is(3));
    }

    @Test
    public void whenAddKeyDuplicateThenValueReplace() {
        mapsHashMap.insert(first, "Желтый");
        mapsHashMap.insert(second, "Зеленый");
        mapsHashMap.insert(three, "Огненный");
        mapsHashMap.insert(four, "КУ");
        assertThat(this.mapsHashMap.getValue(four), is("КУ"));
    }

    @Test
    public void whenAddKeyDuplicateThenSizeDoesNotChange() {
        mapsHashMap.insert(first, "Желтый");
        mapsHashMap.insert(second, "Зеленый");
        mapsHashMap.insert(three, "Огненный");
        mapsHashMap.insert(four, "КУ");
        assertThat(this.mapsHashMap.size(), is(3));
    }


    /*
    16*0,75=12
     */
    @Test
    public void whenArraysIsFullThenReplaceSizeAreeays() {
        MapsHashMap<Integer, Integer> maps = new MapsHashMap<>();
        for (int index = 0; index < 20; index++) {
            maps.insert(index, index);
        }
        assertThat(maps.getSizeTableLength(), is(32));

    }

    @Test
    public void whenDeleteElementThenBooleanTrueorFalse() {
        mapsHashMap.insert(first, "1");
        mapsHashMap.insert(second, "2");
        boolean result = mapsHashMap.delete(second);
        assertThat(result, is(true));
    }

    /*
    Проверка Iterator
     */

    @Test
    public void when() {
        mapsHashMap.insert(first, "1");
        mapsHashMap.insert(second, "2");
        mapsHashMap.insert(three, "3");
        Iterator iterator = mapsHashMap.iterator();

        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }


}