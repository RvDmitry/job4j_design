package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Class SimpleArray
 * Класс реализует ArrayList.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Массив объектов.
     */
    private Object[] objects;
    /**
     * Поле характеризует количество элементов в массиве.
     */
    private int index;
    /**
     * Счетчик ведет подсчет количества модификаций коллекции.
     */
    private int modCount;

    /**
     * Конструктор инициализирует массив объектов.
     */
    public SimpleArray() {
        objects = new Object[10];
    }

    /**
     * Метод возвращает значение элемента массива по заданному индексу.
     *
     * @param index Индекс элемента
     * @return Значение элемента
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) objects[Objects.checkIndex(index, this.index)];
    }

    /**
     * Метод добавляет элемент в массив.
     *
     * @param model Элемент
     */
    public void add(T model) {
        if (index < objects.length) {
            objects[index++] = model;
        } else {
            Object[] temp = new  Object[objects.length * 2];
            System.arraycopy(objects, 0, temp, 0, objects.length);
            objects = temp;
            objects[index++] = model;
        }
        modCount++;
    }

    /**
     * Метод возвращает итератор для обхода данного массива.
     *
     * @return Итератор
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int point = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < index;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[point++];
            }
        };
    }
}
