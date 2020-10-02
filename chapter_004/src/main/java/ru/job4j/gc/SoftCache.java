package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Class SoftCache
 * Класс реализует кеш на SoftReference.
 * @author Dmitry Razumov
 * @version 1
 */
public class SoftCache {
    /**
     * Поле содержит данные кеша.
     */
    private final Map<String, SoftReference<String>> cache = new HashMap<>();
    /**
     * Объект загружающий данные в кеш.
     */
    private final FileLoader loader;

    public SoftCache(FileLoader loader) {
        this.loader = loader;
    }

    /**
     * Метод записывает данные в кеш.
     * @param key Ключ объекта
     * @param value Значение объекта
     * @return Предыдущее значение ключа, если есть.
     */
    public String put(String key, String value) {
        SoftReference<String> previousValue = cache.put(key, new SoftReference<>(value));
        return previousValue != null ? previousValue.get() : null;
    }

    /**
     * Метод возвращает данные из кеша.
     * Если в кеше данных нет, то метод загружает данные из хранилища.
     * При этом сохраняет полученные данные в кеше.
     * @param key Ключ объекта
     * @return Значение объекта
     */
    public String get(String key) {
        SoftReference<String> value = cache.get(key);
        if (value == null || value.get() == null) {
            try {
                String text = loader.load(key);
                cache.put(key, new SoftReference<>(text));
                return text;
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        return value.get();
    }
}
