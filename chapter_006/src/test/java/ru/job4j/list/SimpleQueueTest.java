package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class SimpleQueueTest {
    SimpleQueue<Integer> simple = new SimpleQueue<>();
    @Before
    public void before(){
        simple.push(1);
        simple.push(2);
        simple.push(3);
        simple.push(4);
        simple.push(5);
        simple.push(6);
        simple.push(7);
    }
    @Test(expected = IllegalArgumentException .class)
    public void When(){
       assertThat(simple.poll(),is(1));
        assertThat(simple.poll(),is(2));
        assertThat(simple.poll(),is(3));
        assertThat(simple.poll(),is(4));
        assertThat(simple.poll(),is(5));
        assertThat(simple.poll(),is(6));
        assertThat(simple.poll(),is(7));
        simple.simpleStack.poll();
    }
}