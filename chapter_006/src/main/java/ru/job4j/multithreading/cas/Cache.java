package ru.job4j.multithreading.cas;

/**
 * Interface Cache
 * Интерфейс характеризует кеш моделей.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Cache {
    /**
     * Метод добавляет модель в кеш.
     * @param model Модель.
     * @return true, если модель добавлена успешно, иначе false.
     */
    boolean add(Base model);

    /**
     * Метод обновляет модель в кеше.
     * @param model Модель.
     * @return true, если модель обновлена успешно, иначе false.
     */
    boolean update(Base model);

    /**
     * Метод удаляет модель из кеша.
     * @param model Модель.
     * @return true, если модель удалена успешно, иначе false.
     */
    boolean delete(Base model);
}
