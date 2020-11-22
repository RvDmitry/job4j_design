package ru.job4j.storage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class User
 * Класс характеризует пользователя.
 * @author Dmitry Razumov
 * @version 1
 */
@ThreadSafe
public class User {
    /**
     * Идентификатор пользователя.
     */
    private final int id;
    /**
     * Сумма денег на счете пользователя.
     */
    @GuardedBy("this")
    private int amount;

    /**
     * Конструктор создает пользователя.
     * @param id Идентификатор пользователя.
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Метод возвращает идентификатор пользователя.
     * @return Идентификатор.
     */
    public int getId() {
        return id;
    }

    /**
     * Метод возвращает количество денег на счете пользователя.
     * @return Сумма денег на счете.
     */
    public synchronized int getAmount() {
        return amount;
    }

    /**
     * Метод задает сумму денег на счете пользователя.
     * @param amount Сумма денег.
     */
    public synchronized void setAmount(int amount) {
        this.amount = amount;
    }
}
