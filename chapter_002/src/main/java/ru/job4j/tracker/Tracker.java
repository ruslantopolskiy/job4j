package ru.job4j.tracker;

/**
 * @author Ruslan Topolskiy(ruslan.topolskiy@gmail.com)
 * @version 001
 * @since 11.06.2018
 */

import java.util.*;

public class Tracker {

    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Добавление заявок
     * metod add
     *
     * @param item
     * @return item
     */
    public Item add(Item item) {
        item.setId(String.valueOf(RN.nextInt()));
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Редактирование заявок
     * metod replace
     *
     * @param id
     * @param item
     */
    public void replace(String id, Item item) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = item;
                break;
            }
        }
    }

    /**
     * Удаление заявок
     * metod delete
     *
     * @param id
     */
    public void delete(String id) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.position - index - 1);
                this.position--;
                break;
            }
        }
    }

    /**
     * metod findAll
     *
     * @return
     */

    public Item[] findAll() {
        Item[] findItems = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            findItems[i] = this.items[i];
        }
        return findItems;
    }

    /**
     * metod findByName
     *
     * @param key
     * @return
     */

    public Item[] findByName(String key) {
        Item[] temp = new Item[this.position];
        int count = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                temp[count++] = this.items[index];
            }
        }
        Item[] listOfNames = new Item[count];
        System.arraycopy(temp, 0, listOfNames, 0, count);
        return listOfNames;
    }

    /**
     * metod findById
     *
     * @param id
     * @return
     */

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId() != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
