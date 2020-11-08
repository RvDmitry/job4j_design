package ru.job4j.tictactoe;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Class ConsoleMarkX
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class ConsoleMarkX implements Mark<OutputStream> {
    @Override
    public void print(OutputStream screen) {
        try {
            screen.write("X".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
