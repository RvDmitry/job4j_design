package ru.job4j.io;

import net.jcip.annotations.ThreadSafe;

import java.io.*;

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
        StringBuilder builder = new StringBuilder();
        try (InputStream i = new BufferedInputStream(new FileInputStream(file))) {
            int data;
            while ((data = i.read()) != -1) {
                builder.append((char) data);
            }
        }
        return builder.toString();
    }

    /**
     * Метод считывает текст из файла не в Unicode и возвращает его в виде строки.
     * @return Текст из файла.
     * @throws IOException Исключение.
     */
    public String getContentWithoutUnicode() throws IOException {
        StringBuilder builder = new StringBuilder();
        try (InputStream i = new FileInputStream(file)) {
            int data;
            while ((data = i.read()) != -1) {
                if (data < 0x80) {
                    builder.append((char) data);
                }
            }
        }
        return builder.toString();
    }
}
