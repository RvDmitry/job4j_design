package ru.job4j.multithreading.concurrent;

/**
 * Class ConcurrentOutput
 * В классе практикуется работа с потоками.
 * @author Dmitry Razumov
 * @version 1
 */
public class ConcurrentOutput {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки.
     */
    public static void main(String[] args) {
        Thread another = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        Thread second = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        another.start();
        second.start();
        System.out.println(Thread.currentThread().getName());
    }
}
