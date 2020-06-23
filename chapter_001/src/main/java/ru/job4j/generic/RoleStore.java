package ru.job4j.generic;

/**
 * Class RoleStore
 * Класс описывает хранилище ролей.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class RoleStore implements Store<Role> {
    /**
     * Коллекция для хранения ролей.
     */
    private final Store<Role> store = new MemStore<>();

    /**
     * Метод добавляет роль в хранилище.
     *
     * @param model Роль
     */
    @Override
    public void add(Role model) {
        store.add(model);
    }

    /**
     * Метод заменяет роль в хранилище с заданным id на новую роль.
     *
     * @param id Идентификационный номер заменяемой роли
     * @param model Новая роль
     * @return true, если замена прошла успешно, иначе false
     */
    @Override
    public boolean replace(String id, Role model) {
        return store.replace(id, model);
    }

    /**
     * Метод удаляет роль из хранилища.
     *
     * @param id Идентификационный номер удаляемой роли
     * @return true, если удаление прошло успешно, иначе false
     */
    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    /**
     * Метод ищет и возвращает роль из хранилища по ее id.
     *
     * @param id Идентификационный номер роль
     * @return Роль
     */
    @Override
    public Role findById(String id) {
        return store.findById(id);
    }
}
