package ru.job4j;

/**
 * Class Count
 * Класс счетчик
 * @author Dmitry Razumov
 * @version 1
 */
public class Count {
    /**
     * Значение счетчика.
     */
    private int value;

    /**
     * Метод увеличивает счетчик.
     */
    public synchronized void increment() {
        value++;
    }

    /**
     * Метод возвращает значение счетчика.
     * @return Значение счетчика.
     */
    public synchronized int get() {
        return value;
    }
}
