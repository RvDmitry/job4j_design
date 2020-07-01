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
        Iterator<E> iter = array.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(e)) {
                return;
            }
        }
        array.add(e);
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
