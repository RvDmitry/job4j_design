package ru.job4j.queue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class SimpleBlockingQueue
 * Класс реализует блокирующую очередь.
 * @author Dmitry Razumov
 * @version 1
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    /**
     * Коллекция для хранения элементов очереди.
     */
    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();
    /**
     * Размер очереди.
     */
    private final int size;

    /**
     * Конструктор инициализирует очередь заданного размера.
     * @param size Размер очереди.
     */
    public SimpleBlockingQueue(int size) {
        this.size = size;
    }

    /**
     * Метод добавляет элемент в очередь.
     * @param value Элемент.
     */
    public synchronized void offer(T value) {
        while (queue.size() >= size) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        queue.offer(value);
        notifyAll();
    }

    /**
     * Метод возвращает элемент из очереди.
     * @return Элемент.
     */
    public synchronized T poll() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        T el = queue.poll();
        notifyAll();
        return el;
    }

    /**
     * Метод сообщает пустая ли очередь.
     * @return true, если очередь пустая, иначе false.
     */
    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
