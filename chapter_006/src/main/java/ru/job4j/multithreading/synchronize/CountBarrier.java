package ru.job4j.multithreading.synchronize;

/**
 * Class CountBarrier
 * Класс блокирует выполнение по условию счетчика.
 * @author Dmitry Razumov
 * @version 1
 */
public class CountBarrier {
    /**
     * Объект монитор.
     */
    private final Object monitor = this;
    /**
     * Поле содержит количество вызовов метода count.
     */
    private final int total;
    /**
     * Счетчик вызовов метода count.
     */
    private int count = 0;

    /**
     * Конструктор инициализирует общее количество вызовов метода.
     * @param total Число вызовов.
     */
    public CountBarrier(final int total) {
        this.total = total;
    }

    /**
     * Метод увеличивает счетчик запуска и пробуждает спящие потоки.
     */
    public void count() {
        synchronized (monitor) {
            count++;
            monitor.notifyAll();
        }
    }

    /**
     * Метод заставляет поток спать,
     * пока количество вызовов метода count не будет равно общему количеству запусков.
     */
    public void await() {
        synchronized (monitor) {
            while (count != total) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
