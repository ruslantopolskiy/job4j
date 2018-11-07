package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    // добавление заявки
    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    //получение заявки по id
    public Item findbyId(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    //получение списка по имени
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[count++] = items[index];
            }
        }
        Item[] listOfNames = new Item[count];
        System.arraycopy(result, 0, listOfNames, 0, count);
        return listOfNames;
    }

    //редактирование заявок
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index <= this.position; index++) {
            if (items[index].getId().equals(id)) {
                item.setId(items[index].getId());
                items[index] = item;
                result = true;
                break;
            }
    }
        return result;
    }

    //удаление заявок
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (items[index].getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, this.position - 1 - index);
                this.items[this.position - 1] = null;
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }

    //получение списка всех заявок
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

}
