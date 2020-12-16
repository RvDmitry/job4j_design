package ru.job4j.multithreading;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class MasterSlaveBarrier
 * Класс осуществляет раздельное выполнение двух нитей.
 * Сначала выполняется нить Master, затем нить Slave.
 * @author Dmitry Razumov
 * @version 1
 */
@ThreadSafe
public class MasterSlaveBarrier {
    /**
     * Поле определяет, была ли выполнена нить Master.
     */
    @GuardedBy("this")
    private boolean master = false;

    /**
     * Метод заставляет нить Master ждать, пока не выполнится нить Slave.
     */
    public synchronized void tryMaster() {
        while (master) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Метод заставляет нить Slave ждать, пока не выполнится нить Master.
     */
    public synchronized void trySlave() {
        while (!master) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Метод задает параметр нити Master как выполненной и пробуждает нить Slave.
     */
    public synchronized void doneMaster() {
        master = true;
        notify();
    }

    /**
     * Метод задает параметр нити Master как невыполненной и пробуждает нить Master.
     */
    public synchronized void doneSlave() {
        master = false;
        notify();
    }
}
