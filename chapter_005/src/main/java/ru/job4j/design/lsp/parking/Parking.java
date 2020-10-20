package ru.job4j.design.lsp.parking;

/**
 * Interface Parking
 * Интерфейс описывает парковку автомобилей.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Parking {
    /**
     * Метод размещает автомобиль на парковке.
     * @param car Автомобиль.
     * @return true, если автомобиль размещен на парковке успешно, иначе false.
     */
    boolean park(Car car);

    /**
     * Метод убирает автомобиль с парковки.
     * @param car Автомобиль.
     * @return true, если автомобиль убран с парковки успешно, иначе false.
     */
    boolean unpark(Car car);

    /**
     * Метод возвращает количество легковых машин на парковке.
     * @return Количество машин.
     */
    int numberCars();

    /**
     * Метод возвращает количество грузовых машин на парковке.
     * @return Количество машин.
     */
    int numberTrucks();
}
