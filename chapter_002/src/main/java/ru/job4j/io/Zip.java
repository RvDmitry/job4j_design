package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
     * Метод осуществляет поиск файлов в заданной директории согласно переданному условию.
     * @param root Директория для поиска файлов
     * @param predicate Условие, по которому ищутся файлы
     * @return Список файлов находящихся в директории
     * @throws IOException Исключение, если происходит ошибка чтения файла или каталога
     */
    public List<Path> search(Path root, Predicate<Path> predicate) throws IOException {
        SearchFiles searcher = new SearchFiles(predicate);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    /**
     * Главный метод программы. Осуществляет архивирование отдельно взятого файла.
     * А также заданного каталога. Параметры передаются в метод через конфигурацию приложения.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./chapter_002/pom.xml"),
                new File("./chapter_002/pom.zip")
        );
        ArgZip arg = new ArgZip(args);
        if (!arg.valid()) {
            throw new IllegalArgumentException(
                    "The number of arguments does not match the required value");
        }
        String exclude = arg.exclude();
        List<File> files = zip.search(Paths.get(arg.directory()),
                path -> exclude == null || !path.toString().endsWith(exclude))
                .stream().map(Path::toFile).collect(Collectors.toList());
        zip.packFiles(files, new File(arg.output()));
    }
}
