package ru.job4j.io;

import java.io.File;
import java.io.IOException;

/**
 * Interface FileContent
 * Интерфейс определяет метод считывание содержимого файла.
 * @author Dmitry Razumov
 * @version 1
 */
public interface FileContent {
    /**
     * Метод считывает файл и выводит его содержимое в виде строки.
     * @param file Файл.
     * @return Содержимое файла в виде строки.
     * @throws IOException Исключение.
     */
    String getContent(File file) throws IOException;
}
