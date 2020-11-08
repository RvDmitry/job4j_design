package ru.job4j.tictactoe;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Class ConsoleMarkO
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class ConsoleMarkO implements Mark<OutputStream> {
    @Override
    public void print(OutputStream screen) {
        try {
            screen.write("O".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
