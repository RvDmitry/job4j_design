package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * Interface Cinema
 * Интерфейс описывает кинотеатр.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Cinema {
    /**
     * Метод находит список идущих сеансов согласно заданному фильтру.
     * @param filter Фильтр поиска
     * @return Список сеансов
     */
    List<Session> find(Predicate<Session> filter);

    /**
     * Метод отвечает за покупку билета на сеанс.
     * @param account Аккаунт посетителя
     * @param row Ряд
     * @param column Место
     * @param date Дата сеанса
     * @return Билет
     */
    Ticket buy(Account account, int row, int column, Calendar date);

    /**
     * Метод добавляет сеанс.
     * @param session Сеанс
     */
    void add(Session session);
}
