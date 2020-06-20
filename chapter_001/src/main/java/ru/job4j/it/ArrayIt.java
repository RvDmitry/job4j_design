package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ArrayIt
 * Класс реализует шаблон итератор.
 * @author Dmitry Razumov
 * @version 1
 */
public class ArrayIt implements Iterator<Integer> {
    /**
     * Массив данных.
     */
    private final int[] data;
    /**
     * Указатель на элемент массива.
     */
    private int point = 0;

    /**
     * Конструктор инициализирует массив данных.
     * @param data Массив данных
     */
    public ArrayIt(int[] data) {
        this.data = data;
    }

    /**
     * Метод проверяет существует ли элемент массива.
     * @return true, если элемент существует, иначе false
     */
    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    /**
     * Метод возвращает элементы массива.
     * @return Элемент массива
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
