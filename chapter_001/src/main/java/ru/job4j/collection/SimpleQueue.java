package ru.job4j.collection;

/**
 * Class SimpleQueue
 * Класс реализует коллекцию типа очередь.
 * @author Dmitry Razumov
 * @version 1
 */
public class SimpleQueue<T> {
    /**
     * Коллекция типа стек, для хранения элементов.
     */
    private final SimpleStack<T> in = new SimpleStack<>();
    /**
     * Вспомогательная коллекция типа стек, для временного хранения элементов.
     */
    private final SimpleStack<T> out = new SimpleStack<>();

    /**
     * Метод возвращает первый элемент из коллекции, при этом удаляет его из нее.
     * @return Элемент
     */
    public T poll() {
        reverse(in, out);
        T first = out.pop();
        reverse(out, in);
        return first;
    }

    /**
     * Метод добавляет элемент в конец коллекции.
     * @param value Элемент
     */
    public void push(T value) {
        in.push(value);
    }

    /**
     * Метод перемещает элементы из одной коллекции в другую в обратном порядке.
     * @param source Исходная коллекция
     * @param dest Коллекция, в которую нужно переместить элементы из исходной
     */
    private void reverse(SimpleStack<T> source, SimpleStack<T> dest) {
        T item;
        while (true) {
            try {
                item = source.pop();
            } catch (Exception ex) {
                break;
            }
            dest.push(item);
        }
    }
}
