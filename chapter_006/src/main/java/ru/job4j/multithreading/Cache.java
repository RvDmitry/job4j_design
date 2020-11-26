package ru.job4j.multithreading;

/**
 * Class Cache
 *
 * @author Dmitry Razumov
 * @version 1
 */
public final class Cache {
    private static Cache cache;

    public synchronized static Cache instOf() {
        if (cache == null) {
            cache = new Cache();
        }
        return cache;
    }
}
