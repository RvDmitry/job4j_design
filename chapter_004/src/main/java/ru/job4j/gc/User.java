package ru.job4j.gc;

import com.carrotsearch.sizeof.RamUsageEstimator;

/**
 * Class User
 * В классе демонстрируется работа с GC.
 * @author Dmitry Razumov
 * @version 1
 */
public class User {
    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Конструктор инициализирует имя пользователя.
     * @param name Имя
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Метод переопределяет метод класса Object с целью демонстрации работы GC.
     * @throws Throwable Исключение
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }

    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        System.out.println(RamUsageEstimator.sizeOf(new User("Name")));
        for (int i = 0; i < 1000; i++) {
            new User("user");
        }
        Thread.sleep(10000);
        System.out.println("Finish");
    }
}
