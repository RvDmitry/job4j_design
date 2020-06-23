package ru.job4j.generic;

/**
 * Class Role
 * Класс описывает роль.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class Role extends Base {
    /**
     * Наименование роли.
     */
    private String role;

    /**
     * Конструктор создает роль с заданным id.
     *
     * @param id Идентификационный номер роли
     */
    protected Role(String id) {
        super(id);
    }

    /**
     * Метод возвращает наименование роли.
     *
     * @return Роль
     */
    public String getRole() {
        return role;
    }

    /**
     * Метод задает наименование роли.
     *
     * @param role Роль
     */
    public void setRole(String role) {
        this.role = role;
    }
}
