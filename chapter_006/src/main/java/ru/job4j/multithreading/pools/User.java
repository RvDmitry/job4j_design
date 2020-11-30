package ru.job4j.multithreading.pools;

/**
 * Class User
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class User {
    /**
     * Имя пользователя.
     */
    private final String username;
    /**
     * Email пользователя.
     */
    private final String email;

    /**
     * Конструктор создает пользователя.
     * @param username Имя.
     * @param email Email.
     */
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    /**
     * Метод возвращает имя пользователя.
     * @return Имя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод возвращает email пользователя.
     * @return Email.
     */
    public String getEmail() {
        return email;
    }
}
