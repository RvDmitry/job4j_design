package ru.job4j.multithreading;

/**
 * Class Switcher
 * В классе две нити попеременно выводят сообщение на консоль.
 * Нити выполняются последовательно, сначала выполняется первая нить (A), затем вторая нить (B).
 * Нити работают вечно.
 * @author Dmitry Razumov
 * @version 1
 */
public class Switcher {
    /**
     * Объект вспомогательного класса, который разделяет работу нитей.
     */
    private static MasterSlaveBarrier barrier = new MasterSlaveBarrier();

    /**
     * Главный метод программы.
     * Запускает работу нитей.
     * @param args Параметры командной строки.
     * @throws InterruptedException Исключение.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(
                () -> {
                    while (true) {
                        barrier.tryMaster();
                        System.out.println("Thread A");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        barrier.doneMaster();
                    }
                }
        );
        Thread second = new Thread(
                () -> {
                    while (true) {
                        barrier.trySlave();
                        System.out.println("Thread B");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        barrier.doneSlave();
                    }
                }
        );
        first.start();
        second.start();
        first.join();
        second.join();
    }
}
