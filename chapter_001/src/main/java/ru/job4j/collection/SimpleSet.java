package ru.job4j.collection;

import java.util.Iterator;

/**
 * Class SimpleSet
 * Класс реализует коллекцию Set.
 * @author Dmitry Razumov
 * @version 1
 */
public class SimpleSet<E> implements Iterable<E> {
    /**
     *  Реализация массива для хранения элементов коллекции.
     */
    private final SimpleArray<E> array = new SimpleArray<>();

    /**
     * Метод добавляет элемент в коллекцию. Предварительно проверяется, содержится ли в коллекции
     * данный элемент. Если элемент содержится, то добавления не происходит.
     * @param e Элемент
     */
    public void add(E e) {
        if (!contains(e)) {
            array.add(e);
        }
    }

    /**
     * Метод проверяет, содержит ли коллекция передаваемый элемент.
     * @param e Элемент, который нужно проверить на присутствие его в коллекции
     * @return true, если элемент содержится в коллекции, иначе false
     */
    private boolean contains(E e) {
        Iterator<E> it = array.iterator();
        while (it.hasNext()) {
            E value = it.next();
            if (value != null) {
                if (value.equals(e)) {
                    return true;
                }
            } else {
                if (e == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Метод вовзращает итератор для обхода коллекции.
     * @return Итератор
     */
    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }
}
