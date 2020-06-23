package ru.job4j.generic;

/**
 * Class User
 * Класс описывает пользователя.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class User extends Base {
    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Конструтор создает пользователя с заданным id.
     *
     * @param id Идентификационный номер пользователя
     */
    protected User(String id) {
        super(id);
    }

    /**
     * Метод возвращает имя пользователя.
     *
     * @return Имя
     */
    public String getName() {
        return name;
    }

    /**
     * Метод задает имя пользователя.
     *
     * @param name Имя
     */
    public void setName(String name) {
        this.name = name;
    }
}
