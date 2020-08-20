package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = true;
        while (!rowContainsData(row) || column > data[row].length - 1) {
            if (!rowContainsData(row) && row == data.length - 1) {
                hasNext = false;
                break;
            }
            column = 0;
            row++;
        }
        return hasNext;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }

    private boolean rowContainsData(int row) {
        return Arrays.stream(data[row])
                     .findAny()
                     .isPresent();
    }
}
