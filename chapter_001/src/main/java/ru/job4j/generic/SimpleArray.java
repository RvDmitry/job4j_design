package ru.job4j.generic;

import java.util.*;

/**
 * Class SimpleArray
 * Класс реализует универсальную обертку над массивом.
 * @author Dmitry Razumov
 * @version 1
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Массив объектов.
     */
    private final Object[] objects;
    /**
     * Поле характеризует количество элементов в массиве.
     */
    private int index;
    /**
     * Счетчик ведет подсчет количества модификаций коллекции.
     */
    private int modCount;

    /**
     * Конструтор создает массив с заданным размером.
     * @param size Размер массива
     */
    public SimpleArray(int size) {
        objects = new Object[size];
    }

    /**
     * Метод возвращает счетчик количества модификаций коллекции.
     * @return Счетчик
     */
    public int getModCount() {
        return modCount;
    }

    /**
     * Метод добавляет элемент в массив.
     * @param value Элемент
     */
    public void add(T value) {
        objects[index++] = value;
        modCount++;
    }

    /**
     * Метод задает новое значение для заданного элемента массива.
     * @param position Индекс элемента для которого нужно переопределить значение.
     * @param value Новое значение элемента
     */
    public void set(int position, T value) {
        objects[Objects.checkIndex(position, index)] = value;
        modCount++;
    }

    /**
     * Метод удаляет элемент массива по заданному индексу.
     * При этом элементы справа от удаленного элемента сдвигаются влево на одну позицию.
     * @param position Индекс элемента, который нужно удалить
     */
    public void remove(int position) {
        Objects.checkIndex(position, index);
        System.arraycopy(objects, position + 1, objects, position, index - 1 - position);
        objects[index - 1] = null;
        index--;
        modCount++;
    }

    /**
     * Метод возвращает значение элемента массива по заданному индексу.
     * @param position Индекс элемента
     * @return Значение элемента
     */
    @SuppressWarnings("unchecked")
    public T get(int position) {
        return (T) objects[Objects.checkIndex(position, index)];
    }

    /**
     * Метод возвращает итератор для обхода данного массива.
     * @return Итератор
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;
            private final int count = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != count) {
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
