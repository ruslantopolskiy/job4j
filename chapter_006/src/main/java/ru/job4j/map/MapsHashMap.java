package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MapsHashMap<K, V> implements Iterable {
    private static final float loadfactor = 0.75f;
    private static final int capasity = 16;
    private int threshold;
    private int modCount;
    private int size;
    private Node<K, V>[] table;

    public MapsHashMap() {
        this.threshold = (int) (loadfactor * capasity);
        this.table = new Node[capasity];
    }

    public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    /* Метод replace увеличивает массив в 2 раза по достижению заполнения на 75%*,
    и заного заполняет массив c учётом измененной длинны массива.
     */

    public void replace() {
        Node<K, V>[] oldtable = this.table;
        int oldSize = this.table.length;
        int newSize = oldSize * 2;
        this.threshold = (int) (newSize * loadfactor);
        this.table = new Node[newSize];
        this.size = 0;
        for (Node<K, V> node : oldtable) {
            if (node != null) {
                insert(node.key, node.value);
            }
        }
        oldtable = null;
    }

   /* Метод insert используется для вставки значений K key, V value
   1) Если node ссылается на null -> мы вставляем новый элемент;
   2) Если node ссылается на не пустую ячейку, но ключи равны. Мы перезаписыавем значение.
   3) Мы не обрабатываем коллизиции. return false.
    */

    public boolean insert(K key, V value) {
        boolean result = true;
        if (size + 1 >= threshold) {
            replace();
        }
        int index = indexFor(key.hashCode(), table.length);
        Node<K, V> node = table[index];
        if (node == null) {
            table[index] = new Node<>(key, value);
            size++;
        } else if (node != null & node.key.equals(key)) {
            node.value = value;
        } else {
            result = false;
        }
        modCount++;
        return result;
    }

    /*
    Метод delete используется для удаления элементов из массива
    Если в ячейке содержится элемент, мы сравниваем на иквивалентность. Если key эквиваленты , возвращаем true;
    Если нет false;
     */

    public boolean delete(K key) {
        int index = indexFor(key.hashCode(), this.table.length);
        boolean result = false;
            if (this.table[index]!=null && this.table[index].key.equals(key)) {
                this.table[index] = null;
                result = true;
                this.size--;
                modCount++;
        }
        return result;
    }

    /*
    Метод size используется для получения количетсва кранящихся в массиве объектов
     */
    public int size() {
        return this.size;
    }

    /*
    Метод getSizeTableLength используется для получения длинны массива
     */

    public int getSizeTableLength (){
        return this.table.length;
    }

    /*
    Метод getValue используется для получения значения (Value) по ключу(key)
     */

    public V getValue (K key){
        int index = indexFor(key.hashCode(),this.table.length);
        V result = null;
            if (key.equals(this.table[index].key)){
                result = this.table[index].value;
        }
        return result;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<Node<K, V>>() {
            private int iterCount;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean result = false;
                for (int index = iterCount; index < table.length; index++) {
                    if (table[index] != null) {
                        this.iterCount = index;
                        result = true;
                        break;
                    }
                }
                return result;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[iterCount++];
            }
        };
    }

    private static final class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}