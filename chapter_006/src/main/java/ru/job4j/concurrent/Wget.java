package ru.job4j.concurrent;

/**
 * Class Wget
 * В классе симулируется процесс загрузки.
 * @author Dmitry Razumov
 * @version 1
 */
public class Wget {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки.
     */
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    for (int index = 0; index <= 100; index++) {
                        System.out.print("\rLoading : " + index  + "%");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        thread.start();
    }
}
