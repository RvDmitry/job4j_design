package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ForwardLinked
 * Класс реализует односвязный список.
 * @author Dmitry Razumov
 * @version 1
 */
public class ForwardLinked<T> implements Iterable<T> {
    /**
     * Первый элемент списка.
     */
    private Node<T> head;

    /**
     * Метод добавляет элемент в список.
     * @param value Значение элемента
     */
    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * Метод удаляет первый элемент из списка.
     */
    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
    }

    /**
     * Метод удаляет последний элемент из списка, при этом возвращая удаленный элемент.
     * @return Удаленный элемент
     */
    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tail = head;
        Node<T> pre = null;
        if (head.next == null) {
            head = null;
        } else {
            while (tail.next != null) {
                pre = tail;
                tail = tail.next;
            }
            pre.next = null;
        }
        return tail.value;
    }

    /**
     * Метод возвращает итератор для обхода списка.
     * @return Итератор
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    /**
     * Класс характеризует элемент списка.
     * @param <T> Тип элемента
     */
    private static class Node<T> {
        /**
         * Значение элемента.
         */
        private T value;
        /**
         * Ссылка на следующий элемент.
         */
        private Node<T> next;

        /**
         * Конструктор инициализирует элемент списка.
         * @param value Значение элемента
         * @param next Ссылка на следующий элемент
         */
        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
