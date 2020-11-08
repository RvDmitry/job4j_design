package ru.job4j.tictactoe;

/**
 * Interface Player
 * Интерфейс определяет методы выполняющие ход.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Player {
    /**
     * Метод выполняет ход игрока.
     */
    void turnHuman();

    /**
     * Метод выполняет ход компьютера.
     */
    void turnAI();
}
