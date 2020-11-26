package ru.job4j.multithreading.io;

import net.jcip.annotations.ThreadSafe;

import java.io.*;
import java.util.function.Predicate;

/**
 * Class ParseFile
 * Класс осуществляет парсинг файла.
 * @author Dmitry Razumov
 * @version 1
 */
@ThreadSafe
public class ParseFile {
    /**
     * Поле содержит ссылку на файл.
     */
    private final File file;

    /**
     * Конструктор инициализирует файл.
     * @param file Файл.
     */
    public ParseFile(File file) {
        this.file = file;
    }

    /**
     * Метод считывает текст из файла и возвращает его в виде строки.
     * @return Текст из файла.
     * @throws IOException Исключение.
     */
    public String getContent() throws IOException {
        return content(data -> true);
    }

    /**
     * Метод считывает текст из файла не в Unicode и возвращает его в виде строки.
     * @return Текст из файла.
     * @throws IOException Исключение.
     */
    public String getContentWithoutUnicode() throws IOException {
        return content(data -> data < 0x80);
    }

    /**
     * Метод вычитывает текст из файла и возвращает его ввиде строки.
     * @param filter Фильтр, согласно которому считывается текст.
     * @return Текст из файла.
     * @throws IOException Исключение.
     */
    private String content(Predicate<Integer> filter) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (InputStream i = new FileInputStream(file)) {
            int data;
            while ((data = i.read()) != -1) {
                if (filter.test(data)) {
                    builder.append((char) data);
                }
            }
        }
        return builder.toString();
    }
}
