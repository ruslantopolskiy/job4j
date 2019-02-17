package ru.job4j.map;

import java.util.Iterator;
import java.util.Objects;

public class MapsHashMap<K, V> implements Iterable {
    private int modCount;
    private int size;
    private static final int defaultCapasity = 16;
    private Node<K, V>[] table;

    public MapsHashMap() {
        this.table = new Node[defaultCapasity];
    }

    public int size(){
        return this.size;
    }

    public int hashIndex (K key){
        int hash = 1;
        return hash = (hash*31 + key.hashCode())% this.table.length;
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        int index = hashIndex(key);
        Node<K, V> node = table[index];
        if (node == null) {
            this.table[index] = new Node<>(key, value);
            this.size++;
            this.modCount++;
            result = true;
        }else if (node != null && node.key.equals(key)){
            node.value = value;
            this.size++;
            this.modCount++;
            result =true;
        }
        return result;
    }

    public V get(K key){
        int index = key.hashCode() % table.length;
        if (table[index].key.equals(key)){
            return table[index].value;
        }
        return null;
    }

    public boolean delete (K key){
        boolean result = false;
        if(table[key.hashCode()/table.length] !=null && key.equals(table[key.hashCode()/table.length].key)){
            this.table[key.hashCode()/table.length] = null;
            this.modCount++;
            this.size--;
            result =  true;
        }
        return result;
    }


    @Override
    public Iterator iterator() {
        return null;
    }

    private class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.value = value;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        String[]name = new String[61];
        MapsHashMap mapsHashMap = new MapsHashMap();
          int index = 1052529013;
        System.out.println(index % 16);
    }
}