package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenIt
 * Класс реализует шаблон, возвращая только четные числа.
 * @author Dmitry Razumov
 * @version 1
 */
public class EvenIt implements Iterator<Integer> {
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
    public EvenIt(int[] data) {
        this.data = data;
    }

    /**
     * Метод проверяет существует ли элемент массива.
     * @return true, если элемент существует, иначе false
     */
    @Override
    public boolean hasNext() {
        for (int i = point; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                point = i;
                return true;
            }
        }
        return false;
    }

    /**
     * Метод возвращает четные элементы массива.
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
