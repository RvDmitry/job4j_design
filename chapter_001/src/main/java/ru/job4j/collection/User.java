package ru.job4j.collection;

import java.util.Calendar;

/**
 * Class User
 * Класс описывает пользователя.
 * @author Dmitry Razumov
 * @version 1
 */
public class User {
    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Количество детей.
     */
    private int children;
    /**
     * Дата рождения.
     */
    private Calendar birthday;

    /**
     * Конструктор инициализирует пользователя.
     * @param name Имя
     * @param birthday Дата рождения
     */
    public User(String name, Calendar birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    /**
     * Метод вовзращает количество детей.
     * @return Количество детей
     */
    public int getChildren() {
        return children;
    }

    /**
     * Метод задает количество детей.
     * @param children Количество детей
     */
    public void setChildren(int children) {
        this.children = children;
    }

    /**
     * Метод вовзращает имя пользователя.
     * @return Имя
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает дату рождения пользователя.
     * @return Дата рождения
     */
    public Calendar getBirthday() {
        return birthday;
    }
}
