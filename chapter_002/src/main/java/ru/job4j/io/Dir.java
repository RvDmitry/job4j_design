package ru.job4j.io;

import java.io.File;

/**
 * Class Dir
 * Класс выводит список каталогов в папке projects.
 * @author Dmitry Razumov
 * @version 1
 */
public class Dir {
    /**
     * Главный метод программы. Выводит содержимое заданного каталога.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. "
                    + "Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(
                    String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            System.out.println(subfile.getName() + ": " + getFolderSize(subfile));
        }
    }

    /**
     * Метод вычисляет размер каталога с файлами.
     * @param folder Каталог, размер которого нужно вычислить
     * @return Размер каталога
     */
    private static long getFolderSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();
        int count = files.length;
        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            } else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }
}
