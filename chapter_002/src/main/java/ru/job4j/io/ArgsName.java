package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class ArgsName
 * @author Dmitry Razumov
 * @version 1
 */
public class ArgsName {
    /**
     * Коллекция содержит набор параметров для запуска
     */
    private final Map<String, String> values = new HashMap<>();

    /**
     * Метод возвращает значение ключа.
     * @param key Ключ
     * @return Значение
     */
    public String get(String key) {
        return values.get(key);
    }

    /**
     * Метод принимает массив параметров и разбивает их на пары: ключ, значение.
     * @param args Массив параметров
     */
    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Array contains no arguments");
        }
        Arrays.stream(args).forEach(s ->
                values.put(s.substring(1, s.indexOf('=')), s.substring(s.indexOf('=') + 1))
        );
    }

    /**
     * Метод создает объект с параметрами.
     * @param args Массив параметров
     * @return Объект с параметрами
     */
    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));
        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
