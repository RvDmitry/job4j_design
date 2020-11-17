package ru.job4j.concurrent;

/**
 * Class ThreadState
 * В классе практикуется работа с состоянием потоков.
 * @author Dmitry Razumov
 * @version 1
 */
public class ThreadState {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки.
     */
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> System.out.println("First Thread!")
        );
        Thread second = new Thread(
                () -> System.out.println("Second Thread!")
        );
        System.out.println(first.getState());
        System.out.println(second.getState());
        first.start();
        second.start();
        while (first.getState() != Thread.State.TERMINATED
                || second.getState() != Thread.State.TERMINATED) {
            System.out.print("");
        }
        System.out.println("First Thread is " + first.getState());
        System.out.println("Second Thread is " + second.getState());
        System.out.println("Работа завершена.");
    }
}
