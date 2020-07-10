package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

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
        boolean rsl = false;
        var optNode = findBy(parent);
        if (optNode.isPresent()) {
            var children = optNode.get().getChildren();
            boolean exist = children.stream().anyMatch(node -> node.getValue().equals(child));
            if (!exist) {
                children.add(new Node<>(child));
                return true;
            }
        }
        return rsl;
    }

    /**
     * Метод ищет узел в дереве.
     * @param value Узел
     * @return Узел, если существует или пустой элемент
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.getValue().equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }

    /**
     * Метод проверяет, является ли дерево бинарным.
     * @return true, если дерево бинарное, иначе false
     */
    public boolean isBinary() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            var children = data.poll().getChildren();
            if (children.size() >= 3) {
                return false;
            }
            data.addAll(children);
        }
        return true;
    }
}
