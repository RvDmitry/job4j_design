package ru.job4j.io;

import java.util.Arrays;
import java.util.List;

/**
 * Class ArgSearch
 *  Класс разбирает переданный массив аргументов и возвращает их значения.
 *  А также осуществляет валидацию переданных аргументов.
 * @author Dmitry Razumov
 * @version 1
 */
public class ArgSearch {
    /**
     * Список аргументов.
     */
    private final List<String> args;

    /**
     * Контсруктор инициализирует список аргументов.
     * @param args Массив аргументов
     */
    public ArgSearch(String[] args) {
        this.args = Arrays.asList(args);
    }

    /**
     * Метод осуществляет валидацию переданных аргументов.
     * @return true, если количество параметров соответствует требуемому значению, иначе false
     */
    public boolean valid() {
        if (!(args.contains("-d") && args.contains("-n") && args.contains("-o"))) {
            return false;
        }
        if (!(args.contains("-m") ^ args.contains("-f") ^ args.contains("-r"))) {
            return false;
        }
        return args.size() == 7;
    }

    /**
     * Метод возвращает имя директории, в которой нужно искать файл.
     * @return Имя директории поиска
     */
    public String directory() {
        int i = args.indexOf("-d");
        return args.get(i + 1);
    }

    /**
     * Метод возврашает имя файла, в который сохраняется результат поиска.
     * @return Имя файла с результатом
     */
    public String output() {
        int i = args.indexOf("-o");
        return args.get(i + 1);
    }

    /**
     * Метод возвращает имя файла, который нужно найти. Либо маску, по которой осуществляется поиск.
     * @return Имя файла поиска либо маска файла
     */
    public String name() {
        int i = args.indexOf("-n");
        return args.get(i + 1);
    }

    /**
     * Метод возвращает тип поиска файла:
     * либо поиск осуществляется по полному совпадению с заданным именем файла,
     * либо поиск осуществляется по маске файла,
     * либо поиск осуществляется по регулярному выражению.
     * @return Тип поиска файла
     */
    public String type() {
        return args.stream()
                .filter(s -> s.equals("-m") || s.equals("-f") || s.equals("-r"))
                .findFirst().get();
    }
}
