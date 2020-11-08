package ru.job4j.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class XORulesTest
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class XORulesTest {

    @Test
    public void whenWinnerXTrue() {
        char[][] table = {
                {'X', 'X', 'X'},
                {'X', 'O', ' '},
                {'O', 'O', ' '}
        };
        Rules rules = new XORules(table);
        assertTrue(rules.checkWinX());
    }

    @Test
    public void whenWinnerXFalse() {
        char[][] table = {
                {'X', 'X', ' '},
                {'X', 'O', ' '},
                {'O', 'O', ' '}
        };
        Rules rules = new XORules(table);
        assertFalse(rules.checkWinX());
    }

    @Test
    public void whenWinnerOTrue() {
        char[][] table = {
                {'X', 'X', 'O'},
                {'X', 'O', ' '},
                {'O', 'O', ' '}
        };
        Rules rules = new XORules(table);
        assertTrue(rules.checkWinO());
    }

    @Test
    public void whenWinnerOFalse() {
        char[][] table = {
                {'X', 'X', ' '},
                {'X', 'O', ' '},
                {'O', 'O', ' '}
        };
        Rules rules = new XORules(table);
        assertFalse(rules.checkWinO());
    }
}