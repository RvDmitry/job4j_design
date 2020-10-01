package ru.job4j.gc;

import java.util.Arrays;
import java.util.List;

/**
 * Class StartUI
 * В классе демонстрируется работа кеша на основе SoftReference.
 * @author Dmitry Razumov
 * @version 1
 */
public class StartUI {
    /**
     * Метод обрабатывает действия пользователя при работе с меню.
     * @param input Объект для считывания ответов пользователя
     * @param actions Массив объектов, выполняющих различные действия.
     */
    public void init(Input input, List<UserAction> actions, SoftCache cache) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Выберите номер меню: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, cache);
        }
    }

    /**
     * Метод отображает меню приложения на экране.
     * @param actions Список объектов, содержащих наименование пунктов меню.
     */
    private void showMenu(List<UserAction> actions) {
        System.out.println(System.lineSeparator() + "Меню:");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        String path = StartUI.class.getClassLoader().getResource("cache").getFile();
        FileLoader loader = new FileLoader(path);
        SoftCache cache = new SoftCache(loader);
        List<UserAction> actions = Arrays.asList(
                new ExitAction(),
                new PrintFileAction()
        );
        new StartUI().init(new ConsoleInput(), actions, cache);
    }
}
