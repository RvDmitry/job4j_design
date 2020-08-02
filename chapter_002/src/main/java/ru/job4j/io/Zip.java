package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class Zip
 * Класс осуществляет архивацию файлов.
 * @author Dmitry Razumov
 * @version 1
 */
public class Zip {
    /**
     * Метод выполняет архивацию списка файлов (каталога) в заданный архив.
     * @param sources Список файлов
     * @param target Архив для записи файлов
     */
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод выполняет архивацию файла в заданных архив.
     * @param source Файл
     * @param target Архив
     */
    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Главный метод программы. Осуществляет архивирование отдельно взятого файла.
     * А также заданного каталога. Параметры передаются в метод через конфигурацию приложения.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) throws IOException {
        new Zip().packSingleFile(
                new File("./chapter_002/pom.xml"),
                new File("./chapter_002/pom.zip")
        );
        ArgZip arg = new ArgZip(args);
        if (!arg.valid()) {
            throw new IllegalArgumentException(
                    "The number of arguments does not match the required value");
        }
        List<Path> paths = Search.search(Paths.get(arg.directory()));
        List<File> files = new ArrayList<>();
        String exclude = arg.exclude();
        if (exclude != null) {
            for (Path path : paths) {
                if (path.toString().endsWith(exclude)) {
                    continue;
                }
                files.add(path.toFile());
            }
        } else {
            for (Path path : paths) {
                files.add(path.toFile());
            }
        }
        new Zip().packFiles(files, new File(arg.output()));
    }
}
