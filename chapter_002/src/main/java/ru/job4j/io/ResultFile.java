package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

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
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("result.txt")
                ))) {
            out.write("Hello, world!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
