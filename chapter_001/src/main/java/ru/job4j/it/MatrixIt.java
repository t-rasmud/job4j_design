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
        boolean hasNext = false;
        for (int i = row; i <= data.length - 1; i++) {
            if (rowContainsData(i)) {
                if (i != row || column <= data[i].length - 1) {
                    hasNext = true;
                    break;
                }
            }
        }
        return hasNext;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        for (int i = row; i <= data.length - 1; i++) {
            if (rowContainsData(i) && column <= data[i].length - 1) {
                break;
            } else {
                column = 0;
                row++;
            }
        }
        return data[row][column++];
    }

    private boolean rowContainsData(int row) {
        return Arrays.stream(data[row])
                     .findAny()
                     .isPresent();
    }
}
