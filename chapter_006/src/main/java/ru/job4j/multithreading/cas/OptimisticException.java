package ru.job4j.multithreading.cas;

/**
 * Class OptimisticException
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class OptimisticException extends RuntimeException {

    public OptimisticException(String message) {
        super(message);
    }
}
