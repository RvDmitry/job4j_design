package ru.job4j.io;

import java.io.*;

/**
 * Class UnicodeContent
 * Класс реализует считывание файла в юникод кодировке.
 * @author Dmitry Razumov
 * @version 1
 */
public class UnicodeContent implements FileContent {
    /**
     * Метод считывает файл и выводит его содержимое в виде строки.
     * @param file Файл.
     * @return Содержимое файла в виде строки.
     * @throws IOException Исключение.
     */
    @Override
    public String getContent(File file) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (InputStream i = new BufferedInputStream(new FileInputStream(file))) {
            int data;
            while ((data = i.read()) != -1) {
                builder.append((char) data);
            }
        }
        return builder.toString();
    }
}
