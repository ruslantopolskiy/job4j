package ru.job4j.list;

public class SimpleQueue<T> {
    SimpleStack <T> simpleStack = new SimpleStack<>();
    SimpleStack <T> simpleStackNew = new SimpleStack<>();

    public T poll(){
        while (!simpleStack.isEmpty())
         simpleStackNew.push(simpleStack.poll());
         return simpleStackNew.poll();
    }

    public void push(T value){
        simpleStack.push(value);
    }
}

