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
    @SuppressWarnings({"CheckStyle"})
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            outer:
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("Bye")) {
                            break outer;
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        }
    }
}
