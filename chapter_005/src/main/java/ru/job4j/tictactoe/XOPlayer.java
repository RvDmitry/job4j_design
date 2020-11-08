package ru.job4j.tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 * Class XOPlayer
 * Класс реализует метод выполнения хода.
 * @author Dmitry Razumov
 * @version 1
 */
public class XOPlayer implements Player {
    /**
     * Объект считывает данные вводимые пользователем с консоли.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Объект генерирует числа.
     */
    private Random random = new Random();
    /**
     * Массив хранит значения ходов игроков.
     */
    private char[][] table;

    /**
     * Конструктор инициализирует массив.
     * @param table Массив.
     */
    public XOPlayer(char[][] table) {
        this.table = table;
    }

    /**
     * Метод выполняет ход пользователя.
     */
    @Override
    public void turnHuman() {
        int i, j;
        do {
            System.out.print("Введите номер строки для хода: ");
            i = scanner.nextInt() - 1;
            System.out.print("Введите номер столбца для хода: ");
            j = scanner.nextInt() - 1;
        } while (!isCellValid(i, j));
        table[i][j] = 'X';
    }

    /**
     * Метод выполняет ход компьютера.
     */
    @Override
    public void turnAI() {
        int i, j;
        do {
            i = random.nextInt(table.length);
            j = random.nextInt(table.length);
        } while (!isCellValid(i, j));
        table[i][j] = 'O';
    }

    /**
     * Метод осуществялет валидацию ходов. А также проверят, свободна ли ячейка.
     * @param x Номер строки.
     * @param y Номер столбца.
     * @return true, если ход верный и ячейка свободна, иначе false.
     */
    private boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= table.length || y >= table.length) {
            return false;
        }
        return table[x][y] == ' ';
    }
}
