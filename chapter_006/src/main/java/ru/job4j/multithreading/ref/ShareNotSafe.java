package ru.job4j.multithreading.ref;

/**
 * Class ShareNotSafe
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class ShareNotSafe {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки.
     * @throws InterruptedException Исключение.
     */
    public static void main(String[] args) throws InterruptedException {
        UserCache cache = new UserCache();
        User user = User.of("name");
        cache.add(user);
        Thread first = new Thread(
                () -> {
                    user.setName("rename");
                }
        );
        first.start();
        first.join();
        System.out.println(cache.findById(1).getName());
    }
}
