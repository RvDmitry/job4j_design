package ru.job4j.collection;

import java.util.*;

/**
 * Class SimpleLinked
 * Класс реализует LinkedList.
 * @author Dmitry Razumov
 * @version 1
 */
public class SimpleLinked<E> implements Iterable<E> {
    /**
     * Первый элемент коллекции.
     */
    private Node<E> first;
    /**
     * Последний элемент коллекции.
     */
    private Node<E> last;
    /**
     * Поле характеризует количество элементов в коллекции.
     */
    private int size;
    /**
     * Счетчик ведет подсчет количества модификаций коллекции.
     */
    private int modCount;

    /**
     * Класс характеризует узловой элемент коллекции.
     * @param <E> Тип коллекции
     */
    private static class Node<E> {
        /**
         * Значение узла коллекции.
         */
        private E item;
        /**
         * Ссылка на следующий элемент коллекции.
         */
        private Node<E> next;
        /**
         * Ссылка на предыдущий элемент коллекции.
         */
        private Node<E> prev;

        /**
         * Конструктор инициализирует узел.
         * @param prev Ссылка на предыдущий элемент
         * @param item Значение
         * @param next Ссылка на следующий элемент
         */
        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Метод добавляет элемент в коллекцию.
     * @param value Значение элемента
     */
    public void add(E value) {
        Node<E> node = new Node<>(last, value, null);
        last = node;
        if (first == null) {
            first = node;
        } else {
            node.prev.next = node;
        }
        size++;
        modCount++;
    }

    /**
     * Метод возвращает значение элемента по заданному индексу.
     * @param index Индекс элемента
     * @return Значение элемента
     */
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> rsl = first;
        if (index == size - 1) {
            return last.item;
        }
        for (int i = 0; i != index; i++) {
            rsl = rsl.next;
        }
        return rsl.item;
    }

    /**
     * Метод возвращает размер коллекции.
     * @return Размер
     */
    public int getSize() {
        return size;
    }

    /**
     * Метод возвращает итератор для обхода коллекции.
     * @return Итератор
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private Node<E> node = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E item = node.item;
                node = node.next;
                return item;
            }
        };
    }
}
