package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Analizy
 * Класс анализирует лог сервера и выводит информацию сколько времени сервер бездействовал.
 * @author Dmitry Razumov
 * @version 1
 */
public class Analizy {
    /**
     * Метод считывает лог файл и обработанную информацию о времени
     * бездействия сервера записывает в другой файл.
     * @param source Исходный файл лога сервера
     * @param target Файл содержащий обработанную информацию
     */
    public void unavailable(String source, String target) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            in.lines().filter(s -> s.trim().length() != 0).forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            boolean prev = false;
            for (String s : lines) {
                if ((s.contains("400") || s.contains("500")) && !prev) {
                    out.write(s.substring(s.indexOf(' ') + 1) + ';');
                    prev = true;
                }
                if (!(s.contains("400") || s.contains("500")) && prev) {
                    out.write(s.substring(s.indexOf(' ') + 1) + System.lineSeparator());
                    prev = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
