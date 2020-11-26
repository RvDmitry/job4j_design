package ru.job4j.multithreading.ref;

import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class UserCache
 * Класс реализует кеш пользователей.
 * @author Dmitry Razumov
 * @version 1
 */
@ThreadSafe
public class UserCache {
    /**
     * Коллекция хранит пользователей.
     */
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();
    /**
     * Объект для генерации ключей коллекции.
     */
    private final AtomicInteger id = new AtomicInteger();

    /**
     * Метод добавляет пользователя в хранилище.
     * @param user Пользователь.
     */
    public void add(User user) {
        users.put(id.incrementAndGet(), User.of(user.getName()));
    }

    /**
     * Метод ищет пользователя в хранилище по его идентификатору.
     * @param id Идентификатор.
     * @return Пользователь.
     */
    public User findById(int id) {
        return User.of(users.get(id).getName());
    }

    /**
     * Метод возвращает список пользователей содержащихся в хранилище.
     * @return Список пользователей.
     */
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        for (User user : users.values()) {
            list.add(User.of(user.getName()));
        }
        return list;
    }
}
