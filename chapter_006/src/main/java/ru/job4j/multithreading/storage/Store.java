package ru.job4j.multithreading.storage;

/**
 * Interface Store
 * Интерфейс определяет характеристики хранилища пользователей.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Store {
    /**
     * Метод добавляет пользователя в хранилище.
     * @param user Пользователь.
     * @return true, если пользователь добавлен успешно, иначе false.
     */
    boolean add(User user);

    /**
     * Метод обновляет пользователя в хранилище.
     * @param user Пользователь.
     * @return true, если пользователь обновлен успешно, иначе false.
     */
    boolean update(User user);

    /**
     * Метод удаляет пользователя из хранилища.
     * @param user Пользователь.
     * @return true, если пользователь удален успешно, иначе false.
     */
    boolean delete(User user);
}
