package ru.job4j.io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class AnalizyTest
 * Класс тестирует метод анализа лога сервера.
 * @author Dmitry Razumov
 * @version 1
 */
public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private File source;
    private File target;

    @Before
    public void setUp() throws IOException {
        source = folder.newFile("server.log");
        target = folder.newFile("unavailable.csv");
    }

    @Test
    public void whenTwoPeriodsOfUnavailability() throws IOException {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("200 10:56:01");
        joiner.add("500 10:57:01");
        joiner.add("400 10:58:01");
        joiner.add("200 10:59:01");
        joiner.add("500 11:01:02");
        joiner.add("200 11:02:02");
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(source.getAbsolutePath())
                ))) {
            out.write(joiner.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
            in.lines().forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(lines.size(), is(2));
        assertThat(lines.get(0), is("10:57:01;10:59:01"));
        assertThat(lines.get(1), is("11:01:02;11:02:02"));
    }

    @Test
    public void whenOnePeriodsOfUnavailability() throws IOException {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("200 09:42:05");
        joiner.add("300 10:20:10");
        joiner.add("500 10:35:25");
        joiner.add("500 11:11:50");
        joiner.add("400 11:35:15");
        joiner.add("400 12:26:04");
        joiner.add("300 12:45:30");
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(source.getAbsolutePath())
                ))) {
            out.write(joiner.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
            in.lines().forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(lines.size(), is(1));
        assertThat(lines.get(0), is("10:35:25;12:45:30"));
    }

    @Test
    public void whenThreePeriodsOfUnavailability() throws IOException {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("200 09:42:05");
        joiner.add("400 10:20:10");
        joiner.add("300 10:35:25");
        joiner.add("500 11:11:50");
        joiner.add("200 11:35:15");
        joiner.add("400 12:26:04");
        joiner.add("300 12:45:30");
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(source.getAbsolutePath())
                ))) {
            out.write(joiner.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
            in.lines().forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(lines.size(), is(3));
        assertThat(lines.get(0), is("10:20:10;10:35:25"));
        assertThat(lines.get(1), is("11:11:50;11:35:15"));
        assertThat(lines.get(2), is("12:26:04;12:45:30"));
    }
}