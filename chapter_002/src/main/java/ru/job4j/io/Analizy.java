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
     * @throws IOException Исключение, возникающее при ошибке чтения либо записи файла
     */
    public void unavailable(String source, String target) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String s;
            while ((s = in.readLine()) != null) {
                if ((s.trim().length() != 0)) {
                    lines.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        boolean prev = false;
        for (String s : lines) {
            if ((s.contains("400") || s.contains("500")) && !prev) {
                builder.append(s.substring(s.indexOf(' ') + 1) + ';');
                prev = true;
            }
            if (!(s.contains("400") || s.contains("500")) && prev) {
                builder.append(s.substring(s.indexOf(' ') + 1) + System.lineSeparator());
                prev = false;
            }
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            out.write(builder.toString());
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
