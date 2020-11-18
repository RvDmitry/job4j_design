package ru.job4j.concurrent;

import java.util.Arrays;
import java.util.List;

/**
 * Class ArgValid
 * Класс осуществляет валидацию переданных аргументов через командную строку.
 * @author Dmitry Razumov
 * @version 1
 */
public class ArgValid {
    /**
     * Список аргументов.
     */
    private final List<String> args;
    /**
     * Индекс параметра содержащий значение ограничения скорости скачивания.
     */
    private int indexLimit = 0;
    /**
     * Индекс параметра содержащий значение URL.
     */
    private int indexURL = 0;

    /**
     * Контсруктор инициализирует список аргументов.
     * @param args Массив аргументов
     */
    public ArgValid(String[] args) {
        this.args = Arrays.asList(args);
    }

    /**
     * Метод осуществляет валидацию переданных аргументов.
     * @return true, если количество параметров соответствует требуемому значению, иначе false
     */
    public boolean valid() {
        if (!isInt(args.get(0))) {
            if (!isInt(args.get(1))) {
                return false;
            }
            indexLimit = 1;
        }
        if (!isURL(args.get(0))) {
            if (!isURL(args.get(1))) {
                return false;
            }
            indexURL = 1;
        }
        return args.size() == 2;
    }

    /**
     * Метод возвращает значение ограничения скорости скачивания.
     * @return Число.
     */
    public int limit() {
        return Integer.parseInt(args.get(indexLimit));
    }

    /**
     * Метод возвращает значение параметра являющегося URL.
     * @return Строка.
     */
    public String url() {
        return args.get(indexURL);
    }

    /**
     * Метод проверяет, является ли параметр числом.
     * @param str Параметр.
     * @return true, если параметр является числом, иначе false.
     */
    private boolean isInt(String str) {
        return str.matches("\\d+");
    }

    /**
     * Метод проверяет, является ли параметр URL.
     * @param str Параметр
     * @return true, если параметр является URL, иначе false.
     */
    private boolean isURL(String str) {
        return str.matches("^(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
    }
}
