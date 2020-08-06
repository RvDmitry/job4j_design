package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class EchoServer
 * В классе практикуется работа с сервером.
 * @author Dmitry Razumov
 * @version 1
 */
public class EchoServer {
    /**
     * Константа задает команду прекращения работы сервера.
     */
    private static final String EXIT = "Exit";
    /**
     * Константа задает команду приветствия пользователем бота.
     */
    private static final String HELLO = "Hello";

    /**
     * Метод извлекает текст сообщения, которое отправил пользователь на сервер.
     * @param str Строка, которую считывает сервер
     * @return Текст сообщения
     */
    private static String extract(String str) {
        StringBuilder msg = new StringBuilder();
        int index = str.indexOf("msg=");
        if (index == -1) {
            return null;
        }
        String sub = str.substring(index + 4);
        for (int i = 0; i < sub.length(); i++) {
            if (sub.charAt(i) == ' ') {
                break;
            }
            msg.append(sub.charAt(i));
        }
        return msg.toString();
    }

    /**
     * Главный метод программы. Запускает сервер и отвечает сообщением, значение которого равно
     * сообщению пользователя отправленного серверу.
     * Если пользователь отправил сообщение "Exit", сервер прекращает работу.
     * @param args Параметры командной строки
     * @throws IOException Исключение, генерируется если порт закрыт либо занят
     */
    public static void main(String[] args) throws IOException {
        String answer = null;
        boolean run = true;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (run) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        String msg = extract(str);
                        if (msg != null && msg.equals(EXIT)) {
                            run = false;
                            break;
                        }
                        if (msg != null) {
                            answer = msg;
                        }
                        System.out.println(str);
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    if (run && answer != null) {
                        if (answer.equals(HELLO)) {
                            out.write("Hello, dear friend.".getBytes());
                        } else {
                            out.write(answer.getBytes());
                        }
                    }
                }
            }
        }
    }
}
