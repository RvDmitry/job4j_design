package ru.job4j.io;

import net.jcip.annotations.ThreadSafe;

import java.io.*;

/**
 * Class SaveFile
 * Класс сохраняет текст в файл.
 * @author Dmitry Razumov
 * @version 1
 */
@ThreadSafe
public class SaveFile {
    /**
     * Поле содержит ссылку на файл.
     */
    private final File file;

    /**
     * Конструктор инициализирует файл.
     * @param file Файл.
     */
    public SaveFile(File file) {
        this.file = file;
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
