package ru.job4j.multithreading;

/**
 * Class DCLSingleton
 * В классе реализует паттерн синглтон.
 * @author Dmitry Razumov
 * @version 1
 */
public final class DCLSingleton {

    private static volatile DCLSingleton inst;

    private DCLSingleton() {
    }

    public static DCLSingleton instOf() {
        if (inst == null) {
            synchronized (DCLSingleton.class) {
                if (inst == null) {
                    inst = new DCLSingleton();
                }
            }
        }
        return inst;
    }
}
