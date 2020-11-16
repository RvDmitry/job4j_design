package ru.job4j.concurrent;

/**
 * Class ThreadSleep
 * В классе практикуется остановка работы потока.
 * @author Dmitry Razumov
 * @version 1
 */
public class ThreadSleep {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки.
     */
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    try {
                        System.out.println("Start loading ... ");
                        Thread.sleep(3000);
                        System.out.println("Loaded.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        thread.start();
        System.out.println("Main");
    }
}
