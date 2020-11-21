package ru.job4j.io;

import java.io.*;

/**
 * Class ParseFile
 * Класс осуществляет парсинг файла.
 * @author Dmitry Razumov
 * @version 1
 */
public class ParseFile {
    /**
     * Поле содержит ссылку на файл.
     */
    private volatile File file;

    /**
     * Метод задает ссылку на файл.
     * @param f Файл.
     */
    public synchronized void setFile(File f) {
        file = f;
    }

    /**
     * Метод возвращает ссылку на файл.
     * @return Файл.
     */
    public synchronized File getFile() {
        return file;
    }

    /**
     * Метод считывает текст из файла и возвращает его в виде строки.
     * @return Текст из файла.
     * @throws IOException Исключение.
     */
    public synchronized String getContent() throws IOException {
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
    public synchronized String getContentWithoutUnicode() throws IOException {
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

    /**
     * Метод сохраняет строку в файл.
     * @param content Строка.
     * @throws IOException Исключение.
     */
    public synchronized void saveContent(String content) throws IOException {
        try (OutputStream o = new BufferedOutputStream(new FileOutputStream(file))) {
            byte[] buffer = content.getBytes();
            o.write(buffer);
        }
    }
}
