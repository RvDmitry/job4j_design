package ru.job4j.multithreading.concurrent;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Class FileDownload
 * Класс осуществляет загрузку файла со скоростью 1024 байт в секунду.
 * @author Dmitry Razumov
 * @version 1
 */
public class FileDownload {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки.
     * @throws Exception Исключение.
     */
    public static void main(String[] args) throws Exception {
        String file = "https://raw.githubusercontent.com/peterarsentev/course_test/master/pom.xml";
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
