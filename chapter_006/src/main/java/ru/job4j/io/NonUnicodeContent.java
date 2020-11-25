package ru.job4j.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class NonUnicodeContent
 * Класс реализует считывание файла не в юникод кодировке.
 * @author Dmitry Razumov
 * @version 1
 */
public class NonUnicodeContent implements FileContent {
    /**
     * Метод считывает файл не в юникод кодировке и выводит его содержимое в виде строки.
     * @param file Файл.
     * @return Содержимое файла в виде строки.
     * @throws IOException Исключение.
     */
    @Override
    public String getContent(File file) throws IOException {
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
