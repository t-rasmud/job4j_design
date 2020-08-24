package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int index = point;
        while (index < data.length) {
            if (!isEven(data[index])) {
                index++;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (!isEven(data[point])) {
            point++;
        }
        return data[point++];
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
