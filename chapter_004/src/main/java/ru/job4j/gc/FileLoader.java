package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Class FileLoader
 * Класс осуществляет загрузку данных из файла.
 * @author Dmitry Razumov
 * @version 1
 */
public class FileLoader {
    /**
     * Поле содержит путь к папке.
     */
    private final String source;

    /**
     * Конструктор инициализирует рабочий каталог с файлами.
     * @param source Каталог
     */
    public FileLoader(String source) {
        this.source = source;
    }

    /**
     * Метод возвращает список файлов содержащихся в каталоге.
     * @return Список файлов
     */
    public List<String> getFileList() {
        List<String> list = Collections.emptyList();
        File dir = new File(source);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Каталога %s не существует.", dir.getAbsoluteFile()));
        }
        String[] files = dir.list();
        if (files != null) {
            list = Arrays.asList(files);
        }
        return list;
    }

    /**
     * Метод возвращает содержимое файла.
     * @param name Имя файла
     * @return Текст файла
     */
    public String load(String name) {
        StringJoiner text = new StringJoiner(System.lineSeparator());
        File file = new File(source + File.separator + name);
        if (!file.isFile()) {
            throw new IllegalArgumentException(
                    String.format("Файла %s не существует.", file.getName()));
        }
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            read.lines().forEach(text::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
