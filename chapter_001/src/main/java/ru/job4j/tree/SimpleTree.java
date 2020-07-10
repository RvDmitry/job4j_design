package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Interface SimpleTree
 * Интерфейс характеризует структуру дерево.
 * @author Dmitry Razumov
 * @version 1
 */
public interface SimpleTree<E> {
    /**
     * Метод добавляет дочерний узел к родительскому узлу.
     * @param parent Родительский узел
     * @param child Дочерний узел
     * @return true, если узел добавлен успешно, иначе false
     */
    boolean add(E parent, E child);

    /**
     * Метод ищет узел по его значению.
     * @param value Значение узла
     * @return Узел, если с таким значением элемент существует, иначе пустое значение
     */
    Optional<Node<E>> findBy(E value);

    /**
     * Класс определяет узловой элемент дерева
     * @param <E> Тип узла
     */
    class Node<E> {
        /**
         * Значение узла.
         */
        private final E value;
        /**
         * Список дочерних узлов.
         */
        private final List<Node<E>> children = new ArrayList<>();

        /**
         * Конструтор создает узловой элемент.
         * @param value Значение узла
         */
        public Node(E value) {
            this.value = value;
        }

        /**
         * Метод возвращает значение узла.
         * @return Значение
         */
        public E getValue() {
            return value;
        }

        /**
         * Метод возвращает список дочерних узлов.
         * @return Список узлов
         */
        public List<Node<E>> getChildren() {
            return children;
        }
    }
}
