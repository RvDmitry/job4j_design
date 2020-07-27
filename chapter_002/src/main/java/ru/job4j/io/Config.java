package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Class Config
 * Класс реализует считывание конфигурационного файла.
 * @author Dmitry Razumov
 * @version 1
 */
public class Config {
    /**
     * Путь к файлу.
     */
    private final String path;
    /**
     * Коллекция в которую записываются данные из файла.
     */
    private final Map<String, String> values = new HashMap<>();

    /**
     * Конструктор задает пусть к файлу.
     * @param path Путь к файлу
     */
    public Config(final String path) {
        this.path = path;
    }

    /**
     * Метод загружает файл.
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            read.lines().filter(s -> s.trim().length() != 0 && s.charAt(0) != '#')
                .forEach(s ->
                        values.put(s.substring(0, s.indexOf('=')), s.substring(s.indexOf('=') + 1))
                );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод возвращает значение из файла по заданному ключу.
     * @param key Ключ
     * @return Значение
     */
    public String value(String key) {
        return values.get(key);
    }

    /**
     * Метод возвращает данные из файла в виде строки.
     * @return Строка
     */
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        System.out.println(new Config("chapter_002/src/main/resources/app.properties"));
    }
}
