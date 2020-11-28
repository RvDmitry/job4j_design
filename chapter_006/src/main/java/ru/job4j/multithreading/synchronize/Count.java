package ru.job4j.multithreading.synchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class Count
 * Класс счетчик
 * @author Dmitry Razumov
 * @version 1
 */
@ThreadSafe
public class Count {
    /**
     * Значение счетчика.
     */
    @GuardedBy("this")
    private int value;

    /**
     * Метод увеличивает счетчик.
     */
    public synchronized void increment() {
        this.value++;
    }

    /**
     * Метод возвращает значение счетчика.
     * @return Значение счетчика.
     */
    public synchronized int get() {
        return this.value;
    }
}
