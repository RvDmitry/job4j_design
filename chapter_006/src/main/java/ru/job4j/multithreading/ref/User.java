package ru.job4j.multithreading.ref;

/**
 * Class User
 * Класс реализует пользователя.
 * @author Dmitry Razumov
 * @version 1
 */
public class User {
    /**
     * Идентификатор пользователя.
     */
    private int id;
    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Метод создает пользователя.
     * @param name Имя пользователя.
     * @return Пользователь.
     */
    public static User of(String name) {
        User user = new User();
        user.name = name;
        return user;
    }

    /**
     * Метод возвращает идентификатор пользователя.
     * @return Идентификатор.
     */
    public int getId() {
        return id;
    }

    /**
     * Метод задает идентификатор пользователя.
     * @param id Идентификатор.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Метод возвращает имя пользователя.
     * @return Имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод задает имя пользователя.
     * @param name Имя.
     */
    public void setName(String name) {
        this.name = name;
    }
}