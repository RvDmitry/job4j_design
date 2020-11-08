package ru.job4j.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class XOFieldTest
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class XOFieldTest {

    @Test
    public void whenIsFieldFullTrue() {
        char[][] table = new char[3][3];
        Field field = new XOField(table);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = 'X';
            }
        }
        assertTrue(field.isFieldFull());
     }

    @Test
    public void whenIsFieldFullFalse() {
        char[][] table = new char[3][3];
        Field field = new XOField(table);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = 'X';
            }
        }
        assertFalse(field.isFieldFull());
    }
}