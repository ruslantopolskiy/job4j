package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class SimpleStackTest {
    SimpleStack<Integer> simpleStack;
    @Before
    public void before(){
      simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        simpleStack.push(4);
        simpleStack.push(5);
        simpleStack.push(6);

    }
    @Test
    public void When(){
        assertThat(simpleStack.list.size(),is(6));
    }

    @Test
    public void When2(){
        assertThat(simpleStack.list.get(5),is(6));
    }
    @Test
    public void When3(){
        assertThat(simpleStack.poll(),is(simpleStack.list.get(5)));
        assertThat(simpleStack.list.size(),is(5));
    }

}