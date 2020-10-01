package ru.job4j.gc;

/**
 * Class PrintFileAction
 * Класс выводит текст файла на консоль.
 * Для улучшения быстродействия программы и избежания постоянного обращения к каталогу файлов,
 * в классе используется кеш.
 * @author Dmitry Razumov
 * @version 1
 */
public class PrintFileAction implements UserAction {
    /**
     * Метод возвращает наименование пункта меню.
     * @return Наименование пункта меню
     */
    @Override
    public String name() {
        return "Вывести текст из файла.";
    }

    /**
     * Метод выводит текст файла на консоль.
     * @param input Объект для считывания ответов пользователя
     * @return true, если операция выполнена успешно, иначе false
     */
    @Override
    public boolean execute(Input input, SoftCache cache) {
        try {
            String name = input.askStr("Имя файла: ");
            String text = cache.get(name);
            System.out.println("Содержимое файла:");
            System.out.println(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
