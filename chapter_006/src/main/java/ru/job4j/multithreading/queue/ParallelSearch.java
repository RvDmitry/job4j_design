package ru.job4j.multithreading.queue;

/**
 * Class ParallelSearch
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class ParallelSearch {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки.
     * @throws InterruptedException Исключение.
     */
    public static void main(String[] args) throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);
        Thread consumer = new Thread(
                () -> {
                    while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
                        try {
                            System.out.println(queue.poll());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        Thread producer = new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        try {
                            queue.offer(index);
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        producer.start();
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
    }
}
