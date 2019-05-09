package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> rst = this.findBy(parent);
        if (rst.isPresent()) {
            Node<E> e1 = rst.get();
            if (!e1.leaves().contains(child)) {
                e1.add(new Node<>(child));
                result = true;
            }
        } else {
            throw new InvalidRootException("parent отсутствует");
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rs1 = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> e1 = data.poll();
            if (e1.eqValue(value)) {
                rs1 = Optional.of(e1);
                break;
            }
            for (Node<E> child : e1.leaves()) {
                data.offer(child);
            }
        }
        return rs1;
    }


    public boolean isBinary() {
        boolean result = true;
        Node<E> node;
        Queue<Node<E>> list = new LinkedList<>();
        list.offer(this.root);
        while (!list.isEmpty()) {
            node = list.poll();
            if (node.leaves().size() > 2) {
                result = false;
                break;
            } else {
                for (Node<E> e3 : node.leaves()) {
                    list.offer(e3);
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node;
            Queue<Node<E>> data = new LinkedList<>();

            {
                this.data.offer(root);
            }

            Node<E> next;

            /**
             * Возвращает true, если количество элементов в очереди
             * больше 0.
             *
             * @return - true, если количество элементов в очереди больше 0.
             */
            @Override
            public boolean hasNext() {
                return !this.data.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.node = this.data.poll();
                if (this.node.leaves() != null) {
                    for (Node<E> rst : node.leaves()) {
                        data.offer(rst);
                    }
                }
                return node.getValue();
            }
        };
    }
}