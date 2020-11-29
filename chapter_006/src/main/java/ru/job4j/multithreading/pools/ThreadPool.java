package ru.job4j.multithreading.pools;

import ru.job4j.multithreading.queue.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * Class ThreadPool
 * Класс реализует пул потоков.
 * Пул содержит блокирующую очередь, которая наполняется задачами.
 * Потоки из пула забирают задачи и выполняют их.
 * @author Dmitry Razumov
 * @version 1
 */
public class ThreadPool {
    /**
     * Поле содержит список потоков.
     */
    private final List<Thread> threads = new LinkedList<>();
    /**
     * Поле содержит блокирующую очередь.
     */
    private final SimpleBlockingQueue<Runnable> tasks;

    /**
     * Конструктор создает пул потоков.
     * @param numberOfTasks Количество задач которые может содержать очередь.
     * @param numberOfThreads Количество потов содержащихся в пуле.
     */
    public ThreadPool(int numberOfTasks, int numberOfThreads) {
        tasks = new SimpleBlockingQueue<>(numberOfTasks);
        for (int i = 0; i < numberOfThreads; i++) {
            threads.add(new WorkingThread(tasks));
        }
        for (var thread : threads) {
            thread.start();
        }
    }

    /**
     * Метод добавляет задачу в очередь.
     * @param job Задача.
     * @throws InterruptedException Исключение.
     */
    public synchronized void work(Runnable job) throws InterruptedException {
        tasks.offer(job);
    }

    /**
     * Метод завершает работу потоков из пула.
     */
    public synchronized void shutdown() {
        for (var thread : threads) {
            thread.interrupt();
        }
    }

    /**
     * Метод заставляет пул потоков работать пока все задачи из очереди не будут выполнены.
     */
    public synchronized void waitUntilAllTasksFinished() {
        while (!tasks.isEmpty()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
