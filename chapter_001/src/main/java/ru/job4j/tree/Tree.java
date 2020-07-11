package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

/**
 * Class Tree
 * Класс реализует структуру дерево.
 * @author Dmitry Razumov
 * @version 1
 */
class Tree<E> implements SimpleTree<E> {
    /**
     * Поле определяет корень дерева.
     */
    private final Node<E> root;

    /**
     * Конструктор задает корень дерева.
     * @param root Корневой узел
     */
    Tree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * Метод добавляет дочерний узел к родительскому узлу дерева.
     * @param parent Родитеслький узел
     * @param child Дочерний узел
     * @return true, если дочерний узел добавлен успешно, иначе false
     */
    @Override
    public boolean add(E parent, E child) {
        var opt = findBy(parent);
        if (opt.isEmpty() || findBy(child).isPresent()) {
            return false;
        }
        opt.get().getChildren().add(new Node<>(child));
        return true;
    }

    /**
     * Метод ищет узел в структуре дерева, который имеет заданное значение.
     * @param value Значение узла
     * @return Объект содержащий найденный узел либо пустой объект
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> pre = el -> el.getValue().equals(value);
        return search(pre);
    }

    /**
     * Метод проверяет, является ли дерево бинарным.
     * @return true, если дерево бинарное, иначе false
     */
    public boolean isBinary() {
        Predicate<Node<E>> pre = el -> el.getChildren().size() >= 3;
        return search(pre).isEmpty();
    }

    /**
     * Метод осуществляет поиск узла в структуре дерева, удовлетворяющий переданному условию.
     * @param pre Условие, которому должен соответствовать узел
     * @return Объект содержащий найденный узел либо пустой объект
     */
    private Optional<Node<E>> search(Predicate<Node<E>> pre) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (pre.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }
}
