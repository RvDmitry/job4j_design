package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Class Chat
 * Класс реализует консольный чат.
 * @author Dmitry Razumov
 * @version 1
 */
public class Chat {
    /**
     * Поле служит для сохранения диалога пользователя с ботом.
     */
    private static StringJoiner dialog = new StringJoiner(System.lineSeparator());
    /**
     * Поле создает и инициализирует объект Scanner.
     */
    private static Scanner in = new Scanner(System.in);
    /**
     * Поле определяет активен ли диалог пользователя с ботом или остановлен.
     * Если stop = false, то диалог активен, если stop = true, диалог остановлен.
     */
    private static boolean stop;

    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(
                new FileReader("chapter_002/src/main/resources/chat.txt"))) {
            input.lines().forEach(phrases::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String say = consoleInput();
        while (!say.equals("закончить")) {
            if (say.equals("стоп") || stop) {
                stop = true;
                say = consoleInput();
                continue;
            }
            int index = (int) (Math.random() * phrases.size());
            String answer = phrases.get(index);
            System.out.println(answer);
            dialog.add("Bot: " + answer);
            say = consoleInput();
        }
        saveLog(dialog.toString());
    }

    /**
     * Метод считывает введенный в консоли текст пользователем.
     * @return Текст введенный в консоли
     */
    private static String consoleInput() {
        String say = in.nextLine();
        if (say.equals("продолжить")) {
            dialog.add("I am: " + say);
            stop = false;
            say = in.nextLine();
        }
        if (!stop || say.equals("закончить") || say.equals("стоп")) {
            dialog.add("I am: " + say);
        }
        return say;
    }

    /**
     * Метод записывает диалог пользователя и бота в текстовый файл.
     * @param log Строка содержащая диалог
     */
    private static void saveLog(String log) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("chapter_002/src/main/resources/dialog.txt")))) {
            out.write(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
