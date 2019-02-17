package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class MapsHashMapTest {
    MapsHashMap <User,String> mapsHashMap;
    private User first = new User(
            "Руслан",
            28,
            new GregorianCalendar(1990, 7, 18)
    );
    private User second = new User(
            "Леонид",
            9,
            new GregorianCalendar(2000, 3, 1)
    );
    @Before
    public void before(){
        mapsHashMap = new MapsHashMap();
    }

    @Test

    public void when(){
        mapsHashMap.insert(first,"Желтый");
        mapsHashMap.insert(second,"Зеленый");
        assertThat(this.mapsHashMap.size(), is(2));
    }


}