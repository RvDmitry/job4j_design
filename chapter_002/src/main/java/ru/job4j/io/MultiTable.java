package ru.job4j.io;

import java.io.FileOutputStream;

/**
 * Class MultiTable
 * Класс выводит таблицу умножения в файл.
 * @author Dmitry Razumov
 * @version 1
 */
public class MultiTable {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    String s = String.format("%4d", i * j);
                    out.write(s.getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
