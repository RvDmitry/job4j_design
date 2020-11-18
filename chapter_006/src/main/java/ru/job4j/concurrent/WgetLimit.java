package ru.job4j.concurrent;

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
     * Главный метод программы.
     * @param args Параметры командной строки.
     */
    public static void main(String[] args) {
        ArgValid arg = new ArgValid(args);
        if (!arg.valid()) {
            throw new IllegalArgumentException("Неверно заданы параметры.");
        }
        try (BufferedInputStream in = new BufferedInputStream(new URL(arg.url()).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("file.txt")) {
            byte[] dataBuffer = new byte[arg.limit()];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, arg.limit())) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
