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
 * @version 2
 */
public class Chat {
    /**
     * Константа задает команду начала диалога.
     */
    private static final String START = "продолжить";
    /**
     * Константа задает команду остановки диалога.
     */
    private static final String STOP = "стоп";
    /**
     * Константа задает команду завершения работы программы.
     */
    private static final String FINISH = "закончить";
    /**
     * Поле создает и инициализирует объект Scanner.
     */
    private final Scanner in = new Scanner(System.in);
    /**
     * В список сохраняются фразы считанные из файла.
     */
    private final List<String> phrases = new ArrayList<>();
    /**
     * Поле служит для сохранения диалога пользователя с ботом.
     */
    private final StringJoiner dialog = new StringJoiner(System.lineSeparator());
    /**
     * Поле определяет активен ли диалог пользователя с ботом или остановлен.
     * Если stop = false, то диалог активен, если stop = true, диалог остановлен.
     */
    private boolean stop;

    /**
     * Метод считывает введенный в консоли текст пользователем.
     * @return Текст введенный в консоли
     */
    private String consoleInput() {
        String say = in.nextLine();
        if (say.equals(START)) {
            dialog.add("I am: " + say);
            stop = false;
            say = in.nextLine();
        }
        if (!stop || say.equals(FINISH) || say.equals(STOP)) {
            dialog.add("I am: " + say);
        }
        return say;
    }

    /**
     * Метод записывает диалог пользователя и бота в текстовый файл.
     * @param log Лог-файл диалога
     */
    private void saveLog(String log) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(log)))) {
            out.write(dialog.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод считывает из заданного файла список фраз.
     * @param file Файл из которого нужно вычитать фразы
     */
    private void readFile(String file) {
        try (BufferedReader input = new BufferedReader(
                new FileReader(file))) {
            input.lines().forEach(phrases::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод генерирует ответы бота.
     */
    private void botAnswer() {
        int index = (int) (Math.random() * phrases.size());
        String answer = phrases.get(index);
        System.out.println(answer);
        dialog.add("Bot: " + answer);
    }

    /**
     * Метод запускает чат с ботом.
     */
    public void runChat() {
        String input = "chapter_002/src/main/resources/chat.txt";
        String output = "chapter_002/src/main/resources/dialog.txt";
        readFile(input);
        String say = consoleInput();
        while (!say.equals(FINISH)) {
            if (say.equals(STOP) || stop) {
                stop = true;
                say = consoleInput();
                continue;
            }
            botAnswer();
            say = consoleInput();
        }
        saveLog(output);
    }

    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        new Chat().runChat();
    }
}
