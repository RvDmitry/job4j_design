package ru.job4j.io;

import java.io.FileOutputStream;

/**
 * Class ResultFile
 * Класс записывает данные в файл.
 * @author Dmitry Razumov
 * @version 1
 */
public class ResultFile {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("Hello, world!".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
