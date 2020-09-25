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
     * Фамилия пользователя.
     */
    private String surname;

    /**
     * Конструктор инициализирует имя и фамилию пользователя.
     * @param name Имя
     * @param surname Фамилия
     */
    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
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
        System.out.println(RamUsageEstimator.sizeOf(new User("Name", "surname")));
        for (int i = 0; i < 1000; i++) {
            new User("user", "surname");
        }
        System.out.println("Finish");
    }
}
