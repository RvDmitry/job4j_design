package ru.job4j.multithreading.synch;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.collection.SimpleArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class SingleLockList
 * Класс реализует коллекцию, которая может корректно работать в многопоточной среде.
 * @author Dmitry Razumov
 * @version 1
 */
@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    /**
     * Вспомогательная коллекция для хранения элементов родительской коллекции.
     */
    private final SimpleArray<T> array = new SimpleArray<>();

    /**
     * Метод добавляет элементы в коллекцию.
     * @param value Элемент.
     */
    public synchronized void add(T value) {
        array.add(value);
    }

    /**
     * Метод возвращает элемент из коллекции.
     * @param index Индекс элемента.
     * @return Элемент.
     */
    public synchronized T get(int index) {
        return array.get(index);
    }

    /**
     * Метод возвращает итератор для обхода коллекции.
     * @return Итератор.
     */
    @Override
    public synchronized Iterator<T> iterator() {
        List<T> list = new ArrayList<>();
        for (var el : array) {
            list.add(el);
        }
        return new Iterator<T>() {
            private int point = 0;
            @Override
            public boolean hasNext() {
                return point < list.size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return list.get(point++);
            }
        };
    }
}
