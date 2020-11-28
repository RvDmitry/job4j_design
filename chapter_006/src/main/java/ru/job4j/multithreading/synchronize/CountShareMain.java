package ru.job4j.multithreading.synchronize;

/**
 * Class CountShareMain
 * Класс с двумя нитями, которые увеличивают счетчик.
 * @author Dmitry Razumov
 * @version 1
 */
public class CountShareMain {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки.
     * @throws InterruptedException Исключение.
     */
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Thread first = new Thread(count::increment);
        Thread second = new Thread(count::increment);
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println(count.get());
    }
}
