package ru.job4j.design.isp;

/**
 * Interface Input
 * Интерфейс определяет работу класса по получению данных от пользователя.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Input {
    /**
     * Метод возвращает введенную строку от пользователя.
     * @param question Вопрос на который нужно ответить пользователю
     * @return Строка введенная пользователем
     */
    String askStr(String question);

    /**
     * Метод возвращает введенное число от пользователя.
     * @param question Вопрос на который нужно ответить пользователю
     * @return Число введенное пользователем
     */
    int askInt(String question);

    /**
     * Метод запрашивает от пользователя ввод данных от 0 до max.
     * @param question Вопрос на который нужно ответить пользователю
     * @param max Максимальное число, которое может ввести пользователь
     * @return Число введенное пользователем
     */
    int askInt(String question, int max);
}
