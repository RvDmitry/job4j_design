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
     * Главный метод программы.
     * @param args Параметры командной строки
     * @throws IOException Исключение, генерируется если порт закрыт либо занят
     */
    public static void main(String[] args) throws IOException {
        boolean run = true;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (run) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        if (str.contains("Bye")) {
                            run = false;
                            break;
                        }
                        System.out.println(str);
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        }
    }
}
