package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Linked<T> implements Iterable<T> {
    private Node<T> first;
    private int count = 0;
    private int modCount = 0;

    public void add(T model) {
        Node<T> node = new Node<>(model, null);
        count++;
        modCount++;
        if (first == null) {
            first = node;
            return;
        }
        Node<T> current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public T get(int index) {
        checkIndex(index, count);
        Node<T> current = first;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current.value;
    }

    private static int checkIndex(int index, int length) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        return index;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = first;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
