package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class LogFilter
 * Класс считывает лог файл и выводит результат на консоль.
 * @author Dmitry Razumov
 * @version 1
 */
public class LogFilter {
    /**
     * Метод считывает лог файл и формирует из него список.
     * В список включаются строки удовлетворяющие определенному условию.
     * @param file Файл, который нужно вычитать
     * @return Список, содержащий необходимые строки
     */
    public static List<String> filter(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().filter(s -> s.contains(" 404 ")).forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Метод записывает данные из списка в файл.
     * @param log Список, который нужно записать в файл
     * @param file Файл для записи
     */
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)))) {
            for (String s : log) {
                out.write(s + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Главный метод программы. Выводит данные из лог-файла на экран.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}
