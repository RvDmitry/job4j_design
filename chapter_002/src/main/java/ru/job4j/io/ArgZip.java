package ru.job4j.io;

import java.util.Arrays;
import java.util.List;

/**
 * Class ArgZip
 * Класс разбирает переданный массив аргументов и возвращает их значения.
 * А также осуществляет валидацию переданных аргументов.
 * @author Dmitry Razumov
 * @version 1
 */
public class ArgZip {
    /**
     * Список аргументов.
     */
    private final List<String> args;

    /**
     * Контсруктор инициализирует список аргументов.
     * @param args Массив аргументов
     */
    public ArgZip(String[] args) {
        this.args = Arrays.asList(args);
    }

    /**
     * Метод проводит валидацию переданных аргументов.
     * Обязательным является наличие двух клучей,
     * которые обозначают каталог для архивации и имя архива.
     * Ключ задающий файлы для исключения не является обязательным.
     * В связи с этим, итоговое количество параметров должно равняться 4 или 6 параметрам.
     * @return true, если количество параметров соответствует требуемому значению, иначе false
     */
    public boolean valid() {
        if (!(args.contains("-d") && args.contains("-o"))) {
            return false;
        }
        return args.size() == 4 || args.size() == 6;
    }

    /**
     * Метод возвращает директорию, которую необходимо заархивировать.
     * @return Имя директории
     */
    public String directory() {
        int i = args.indexOf("-d");
        return args.get(i + 1);
    }

    /**
     * Метод возвращает расширение файлов, которые не нужно включать в архив.
     * @return Имя расширения файлов либо null, если ключ задан не был.
     */
    public String exclude() {
        int i = args.indexOf("-e");
        if (i == -1) {
            return null;
        }
        return args.get(i + 1);
    }

    /**
     * Метод возвращает наименование архива.
     * @return Имя архива
     */
    public String output() {
        int i = args.indexOf("-o");
        return args.get(i + 1);
    }
}
