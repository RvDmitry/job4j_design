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
     * Количество элементов в коллекции.
     */
    private int count;

    /**
     * Метод удаляет последний элемент коллекции, при этом возвращает его.
     * @return Удаленный элемент
     */
    public T pop() {
        T item = linked.deleteLast();
        count--;
        return item;
    }

    /**
     * Метод добавляет элемент в коллекцию.
     * @param value Элемент
     */
    public void push(T value) {
        linked.add(value);
        count++;
    }

    /**
     * Метод проверяет является ли коллекция пустой.
     * @return true, если коллекция пустая, иначе false
     */
    public boolean isEmpty() {
        return count == 0;
    }
}
