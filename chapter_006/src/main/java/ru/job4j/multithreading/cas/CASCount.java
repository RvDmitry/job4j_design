package ru.job4j.multithreading.cas;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Class CASCount
 * Класс реализует потокобезопасный неблокирующий счетчик.
 * @author Dmitry Razumov
 * @version 1
 */
@ThreadSafe
public class CASCount {
    /**
     * Объект для хранения значений счетчика.
     */
    private final AtomicReference<Integer> count = new AtomicReference<>(0);

    /**
     * Метод увеличивает значение счетчика на единицу.
     */
    public void increment() {
        int current;
        int next;
        do {
            current = count.get();
            next = current + 1;
        } while (!count.compareAndSet(current, next));
    }

    /**
     * Метод возвращает значение счетчика.
     * @return Число.
     */
    public int get() {
        return count.get();
    }
}
