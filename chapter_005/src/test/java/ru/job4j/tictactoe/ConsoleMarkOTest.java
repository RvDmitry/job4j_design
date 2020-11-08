package ru.job4j.tictactoe;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class ConsoleMarkOTest
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class ConsoleMarkOTest {

    @Test
    public void print() {
        var out = new ByteArrayOutputStream();
        new ConsoleMarkO().print(out);
        assertThat(out.toString(), is("O"));
    }
}