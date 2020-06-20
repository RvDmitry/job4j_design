package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MatrixIt
 * Класс реализует шаблон итератор для двухмерного массива.
 * @author Dmitry Razumov
 * @version 1
 */
public class MatrixIt implements Iterator<Integer> {
    /**
     * Массив данных.
     */
    private final int[][] data;
    /**
     * Строка массива.
     */
    private int row = 0;
    /**
     * Столбец массива.
     */
    private int column = 0;

    /**
     * Конструктор инициализирует массив данных.
     * @param data Массив данных.
     */
    public MatrixIt(int[][] data) {
        this.data = data;
    }

    /**
     * Метод проверяет существует ли элемент массива.
     * @return true, если элемент существует, иначе false
     */
    @Override
    public boolean hasNext() {
        while (row < data.length && column == data[row].length) {
            row++;
            column = 0;
        }
        return row < data.length;
    }

    /**
     * Метод возвращает последовательно элементы массива.
     * @return Элемент массива
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}
