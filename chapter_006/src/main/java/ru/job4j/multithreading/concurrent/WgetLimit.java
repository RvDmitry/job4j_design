package ru.job4j.multithreading.concurrent;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Class WgetLimit
 * Класс осуществляет загрузку файла с заданной скоростью.
 * @author Dmitry Razumov
 * @version 1
 */
public class WgetLimit {
    /**
     * Метод осуществляет скачивание файла из интернета с заданной скоростью.
     * @param url Адрес по которому находится файл.
     * @param limit Скорость скачивания.
     */
    public void download(String url, int limit) {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("file.txt")) {
            byte[] dataBuffer = new byte[100];
            int bytesRead;
            long startTime = System.currentTimeMillis();
            while ((bytesRead = in.read(dataBuffer, 0, 100)) != -1) {
                long time = System.currentTimeMillis() - startTime;
                long expected = 1000 * bytesRead / limit;
                if (time < expected) {
                    Thread.sleep(expected - time);
                }
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                startTime = System.currentTimeMillis();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Главный метод программы.
     * @param args Параметры командной строки.
     */
    public static void main(String[] args) {
        ArgValid arg = new ArgValid(args);
        if (!arg.valid()) {
            throw new IllegalArgumentException("Неверно заданы параметры.");
        }
        new WgetLimit().download(arg.url(), arg.limit());
    }
}
