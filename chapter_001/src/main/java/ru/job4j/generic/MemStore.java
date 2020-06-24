package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Class MemStore
 * Класс определяет универсальное хранилище.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public final class MemStore<T extends Base> implements Store<T> {
    /**
     * Коллекция для хранения объектов.
     */
    private final List<T> mem = new ArrayList<>();

    /**
     * Метод добавляет объект в коллекцию.
     *
     * @param model Объект
     */
    @Override
    public void add(T model) {
        mem.add(model);
    }

    /**
     * Метод ищет в коллекции объект по id и заменяет его на другой объект.
     *
     * @param id Идентификационный номер объекта
     * @param model Объект
     * @return true, если объект заменен успешно, иначе false
     */
    @Override
    public boolean replace(String id, T model) {
        int index = findIndex(id);
        if (index != -1) {
            mem.set(index, model);
            return true;
        }
        return false;
    }

    /**
     * Метод удаляет объект из коллекции по его id.
     *
     * @param id Идентификационный номер объекта
     * @return true, если объект успешно удален, иначе false
     */
    @Override
    public boolean delete(String id) {
        int index = findIndex(id);
        if (index != -1) {
            mem.remove(index);
            return true;
        }
        return false;
    }

    /**
     * Метод ищет объект по его id.
     *
     * @param id Идентификационный номер объекта
     * @return Объект
     */
    @Override
    public T findById(String id) {
        return mem.stream().filter(o -> o.getId().equals(id))
                .findFirst().orElse(null);
    }

    /**
     * Метод осуществляет поиск индекса объекта в коллекции по его id.
     * @param id Идентификационный номер объекта
     * @return Индекс объекта в коллекции
     */
    private int findIndex(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
