package ru.job4j.io;

import java.io.FileInputStream;

/**
 * Class EvenNumberFile
 * Класс считывает числа из файла, проверяет являются ли числа четными.
 * @author Dmitry Razumov
 * @version 1
 */
public class EvenNumberFile {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] lines = text.toString().split(System.lineSeparator());
        for (String line : lines) {
            int number = Integer.parseInt(line);
            if (number % 2 == 0) {
                System.out.println(number + " - четное число");
            } else {
                System.out.println(number + " - нечетное число");
            }
        }
    }
}
