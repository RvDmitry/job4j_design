package ru.job4j.concurrent;

/**
 * Class ThreadStop
 * В классе практикуется прерывание потока.
 * @author Dmitry Razumov
 * @version 1
 */
public class ThreadStop {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки.
     * @throws InterruptedException Исключение.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
                () -> {
                    int count = 0;
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.println(count++);
                    }
                }
        );
        thread.start();
        Thread.sleep(1);
        thread.interrupt();
    }
}
