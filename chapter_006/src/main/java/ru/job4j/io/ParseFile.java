package ru.job4j.io;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.*;

/**
 * Class ParseFile
 * Класс осуществляет парсинг файла.
 * @author Dmitry Razumov
 * @version 1
 */
@ThreadSafe
public class ParseFile implements FileContent {
    /**
     * Стратегия с помощью которой считывается файл.
     */
    @GuardedBy("this")
    private volatile FileContent content;

    /**
     * Метод задает стратегию считывание файла.
     * @param content Стратегия.
     */
    public synchronized void setContent(FileContent content) {
        this.content = content;
    }

    /**
     * Метод считывает текст из файла с помощью заданной стратегии.
     * @param file Файл.
     * @return Содержимое файла в виде строки.
     * @throws IOException Исключение.
     */
    public String getContent(File file) throws IOException {
        return content.getContent(file);
    }
}
