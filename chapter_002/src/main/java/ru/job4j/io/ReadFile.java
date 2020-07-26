package ru.job4j.io;

import java.io.FileInputStream;

/**
 * Class ReadFile
 * Класс считывает данные из файла.
 * @author Dmitry Razumov
 * @version 1
 */
public class ReadFile {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
