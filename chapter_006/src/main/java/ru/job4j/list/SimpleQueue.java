package ru.job4j.list;

public class SimpleQueue<T> {
    DynamicList<T> dynamicList = new DynamicList<>();
    public T poll(){
        return dynamicList.delete();
    }

    public void push(T value){
        dynamicList.addFirst(value);
    }
}

