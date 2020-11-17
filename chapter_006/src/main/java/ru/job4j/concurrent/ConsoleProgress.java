package ru.job4j.concurrent;

/**
 * Class ConsoleProgress
 * В классе практикуется прерывание потока.
 * @author Dmitry Razumov
 * @version 1
 */
public class ConsoleProgress implements Runnable {
    /**
     * Метод выводит в консоль прогресс в виде псевдографического шара.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.print("\r load: " + "\\");
                Thread.sleep(500);
                System.out.print("\r load: " + "|");
                Thread.sleep(500);
                System.out.print("\r load: " + "/");
                Thread.sleep(500);
                System.out.print("\r load: " + "——");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    /**
     * Главный метод программы.
     * Создает и прерывает поток выводящий в консоль псевдографический шар загрузки.
     * @param args Параметры командной строки.
     */
    public static void main(String[] args) {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        progress.interrupt();
    }
}
