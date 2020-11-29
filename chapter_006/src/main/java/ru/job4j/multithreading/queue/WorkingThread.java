package ru.job4j.multithreading.queue;

/**
 * Class WorkingThread
 * Класс реализует поток, который принимает блокирующую очередь.
 * Очередь должна содержать задача. Поток выполняет задачи из очереди.
 * @author Dmitry Razumov
 * @version 1
 */
public class WorkingThread extends Thread {
    /**
     * Очередь с задачами.
     */
    private final SimpleBlockingQueue<Runnable> queue;

    /**
     * Конструтор создает поток и передает в него очередь с задачами.
     * @param queue Очередь.
     */
    public WorkingThread(SimpleBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    /**
     * Метод запускает задачи из очереди.
     */
    @Override
    public synchronized void run() {
        while (!isInterrupted()) {
            try {
                Runnable task =  queue.poll();
                task.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
