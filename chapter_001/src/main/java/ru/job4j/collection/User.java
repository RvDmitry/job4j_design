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

    @SuppressWarnings("checkstyle:EqualsHashCode")
    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    /**
     * Главный метод программы. В методе исследуется работа с коллекцией типа Map.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        User user1 = new User("Ivan", new GregorianCalendar(1990, 0, 20));
        user1.setChildren(2);
        User user2 = new User("Ivan", new GregorianCalendar(1990, 0, 20));
        user2.setChildren(2);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
    }
}
