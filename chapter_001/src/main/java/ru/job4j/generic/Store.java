package ru.job4j.generic;

/**
 * Interface Store
 * Интерфейс описывает контейнер для хранения объектов.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public interface Store<T extends Base> {
    /**
     * Метод добавляет элемент в контейнер.
     *
     * @param model Элемент
     */
    void add(T model);

    /**
     * Метод заменяет элемент с заданным id на новый элемент.
     *
     * @param id Идентификационный номер заменяемого элемента
     * @param model Замещяющий элемент
     * @return true, если замена прошла успешно, иначе false
     */
    boolean replace(String id, T model);

    /**
     * Метод удаляет элемент с заданным id.
     *
     * @param id Идентификационный номер удаляемого элемента
     * @return true, если удаление прошло успешно, иначе false
     */
    boolean delete(String id);

    /**
     * Метод находит и возвращает элемент с заданным id.
     *
     * @param id Идентификационный номер элемента
     * @return Элемент
     */
    T findById(String id);
}
