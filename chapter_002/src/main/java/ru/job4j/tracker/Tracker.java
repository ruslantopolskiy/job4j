package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();
    // добавление заявок
    public Item add(Item item) {
        item.setId(String.valueOf(RN.nextInt()));
        this.items[this.position++] = item;
        return item;
    }
    //редактирование заявок
    public void replace(String id, Item item) {
    }
    //удаление заявок
    public void delete(String id) {
    }
    //получение списка всех заявок
    public Item[] findAll() {
        return null;
    }
    //получение списка по имени
    public Item[] findByName(String key) {
        return null;
    }

    //Получение списка по имени
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        } return result;
    }
}
