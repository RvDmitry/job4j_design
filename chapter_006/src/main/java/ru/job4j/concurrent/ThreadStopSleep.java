package ru.job4j.concurrent;

/**
 * Class ThreadStopSleep
 * В классе практикуется прерывание спящего потока.
 * @author Dmitry Razumov
 * @version 1
 */
public class ThreadStopSleep {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки.
     * @throws InterruptedException Исключение.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            System.out.println("start ...");
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        progress.start();
        Thread.sleep(1000);
        progress.interrupt();
        progress.join();
    }
}
