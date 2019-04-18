package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker implements ITracker {
    private List<Item> items = new ArrayList<>();
    private int position = 0;
    private static final Random RN = new Random();

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    // добавление заявки
    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        position++;
        return item;
    }

    //получение заявки по id
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if ( item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    //получение списка по имени
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (int index = 0; index < this.position; index++) {
            if (this.items.get(index).getName().equals(key)) {
                result.add(items.get(index));
            }
        }
        return result;
    }

    //редактирование заявок
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index <= this.position; index++) {
            if (this.items.get(index).getId().equals(id)) {
                item.setId(items.get(index).getId());
                items.set(index, item);
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
            if (items.get(index).getId().equals(id)) {
                this.items.remove(index);
                result = true;
                break;
            }
        }
        return result;
    }

    //получение списка всех заявок
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        result.addAll(items);
        return result;
    }

}
