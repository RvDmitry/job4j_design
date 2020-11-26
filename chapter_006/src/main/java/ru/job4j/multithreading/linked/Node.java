package ru.job4j.multithreading.linked;

import net.jcip.annotations.Immutable;

/**
 * Class Node
 * Класс реализует неизменяемый объект, описывающий узел односвязного списка
 * @author Dmitry Razumov
 * @version 1
 */
@Immutable
public final class Node<T> {
    /**
     * Поле содержит ссылку на следующий элемент.
     */
    private final Node<T> next;
    /**
     * Поле содержит значение узла.
     */
    private final T value;

    /**
     * Конструктор создает и инициализирует элемент списка.
     * @param next Ссылка на следующий элемент.
     * @param value Значение узла.
     */
    public Node(Node<T> next, T value) {
        this.next = next;
        this.value = value;
    }

    /**
     * Метод возвращает ссылку на следующий элемент.
     * @return Элемент списка.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Метод возвращает значение узла.
     * @return Значение узла.
     */
    public T getValue() {
        return value;
    }
}
