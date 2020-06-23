package ru.job4j.generic;

/**
 * Class UserStore
 * Класс описывает хранилище пользователей.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class UserStore implements Store<User> {
    /**
     * Коллекция для хранения пользователей.
     */
    private final Store<User> store = new MemStore<>();

    /**
     * Метод добавляет пользователя в хранилище.
     *
     * @param model Пользователь
     */
    @Override
    public void add(User model) {
        store.add(model);
    }

    /**
     * Метод заменяет пользователя в хранилище с заданным id на нового пользователя.
     *
     * @param id Идентификационный номер пользователя
     * @param model Новый пользователь
     * @return true, если замена прошла успешно, иначе false
     */
    @Override
    public boolean replace(String id, User model) {
        return store.replace(id, model);
    }

    /**
     * Метод удаляет пользователь из хранилища.
     *
     * @param id Идентификационный номер пользователя
     * @return true, если удаление прошло успешно, иначе false
     */
    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    /**
     * Метод ищет и возвращает пользователя из хранилища по его id.
     *
     * @param id Идентификационный номер пользователя
     * @return Пользователь
     */
    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
