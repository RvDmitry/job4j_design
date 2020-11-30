package ru.job4j.multithreading.cas;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * Class CASCache
 * Класс реализует неблокирующий потокобезопасный кеш.
 * @author Dmitry Razumov
 * @version 1
 */
public class CASCache implements Cache {
    /**
     * Коллекция хранит модели.
     */
    private final ConcurrentHashMap<Integer, Base> bases = new ConcurrentHashMap<>();

    /**
     * Метод добавляет модель в кеш.
     * @param model Модель.
     * @return true, если модель успешно добавлена в кеш, иначе false.
     */
    @Override
    public boolean add(Base model) {
        return bases.putIfAbsent(model.getId(), model) == null;
    }

    /**
     * Метод обновляет модель в кеше.
     * @param model Модель.
     * @return true, если модель обновлена в кеше успешно, иначе false.
     */
    @Override
    public boolean update(Base model) throws OptimisticException {
        BiFunction<Integer, Base, Base> biFun = (key, value) -> {
            int version = model.getVersion();
            if (value.getVersion() != version) {
                throw new OptimisticException("Модель была изменена.");
            }
            model.setVersion(++version);
            return model;
        };
        Base newValue = bases.computeIfPresent(model.getId(), biFun);
        return newValue != null;
    }

    /**
     * Метод удаляет модель из кеша.
     * @param model Модель.
     * @return true, если модель успешно удалена из кеша, иначе false.
     */
    @Override
    public boolean delete(Base model) {
        return bases.remove(model.getId()) != null;
    }

    /**
     * Метод возвращает количество моделей в кеше.
     * @return Количество моделей.
     */
    public int getSize() {
        return bases.size();
    }
}
