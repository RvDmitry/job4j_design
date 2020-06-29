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
        T item;
        while (true) {
            try {
                item = in.pop();
            } catch (Exception ex) {
                break;
            }
            out.push(item);
        }
        T first = out.pop();
        while (true) {
            try {
                item = out.pop();
            } catch (Exception ex) {
                break;
            }
            in.push(item);
        }
        return first;
    }

    /**
     * Метод добавляет элемент в конец коллекции.
     * @param value Элемент
     */
    public void push(T value) {
        in.push(value);
    }
}
