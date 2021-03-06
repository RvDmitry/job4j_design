package ru.job4j.collection;

import java.util.*;

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
    private final String name;
    /**
     * Количество детей.
     */
    private int children;
    /**
     * Дата рождения.
     */
    private final Calendar birthday;

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

    /**
     * Метод переопределяет метод сравнения двух объектов.
     * @param o Объект User
     * @return true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    /**
     * Метод переопределяет метод вычисления хеш-кода объекта.
     * @return Хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
