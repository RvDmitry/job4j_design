package ru.job4j.collection;

/**
 * Class SimpleStack
 * Класс реализует Stack.
 * @author Dmitry Razumov
 * @version 1
 */
public class SimpleStack<T> {
    /**
     * Односвязный список для хранения элементов коллекции.
     */
    private final ForwardLinked<T> linked = new ForwardLinked<>();

    /**
     * Метод удаляет последний элемент коллекции, при этом возвращает его.
     * @return Удаленный элемент
     */
    public T pop() {
        return linked.deleteLast();
    }

    /**
     * Метод добавляет элемент в коллекцию.
     * @param value Элемент
     */
    public void push(T value) {
        linked.add(value);
    }
}
