package ru.job4j.design.lsp.parking;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Class CarParking
 * Класс описывает парковку машин.
 * @author Dmitry Razumov
 * @version 1
 */
public class CarParking implements Parking {
    /**
     * Массив содержит машины на парковке для легковых автомобилей.
     */
    private final Car[] cars;
    /**
     * Массив содержит машины на парковке для грузовых автомобилей.
     */
    private final Car[] trucks;

    /**
     * Конструктор инициализирует парковку для машин.
     * @param c Количество мест для легковых машин.
     * @param t Количество мест для грузовых машин.
     */
    public CarParking(int c, int t) {
        cars = new Car[c];
        trucks = new Car[t];
    }

    /**
     * Метод осуществляет парковку машины.
     * @param car Автомобиль.
     * @return true, если машина установлена на парковку, иначе false.
     */
    @Override
    public boolean park(Car car) {
        if (checkPark(car)) {
            return false;
        }
        if (car.getN() == 1) {
            for (int i = 0; i < cars.length; i++) {
                if (cars[i] == null) {
                    cars[i] = car;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < trucks.length; i++) {
                if (trucks[i] == null) {
                    trucks[i] = car;
                    return true;
                }
            }
            int check = 0;
            for (int i = 0; i < cars.length; i++) {
                if (cars[i] == null) {
                    if (++check == car.getN()) {
                        while (check-- > 0) {
                            cars[i--] = car;
                        }
                        return true;
                    }
                } else {
                    check = 0;
                }
            }
        }
        return false;
    }

    /**
     * Метод осуществляет удаление машины с парковки.
     * @param car Автомобиль.
     * @return true, если машина убрана с парковки, иначе false.
     */
    @Override
    public boolean unpark(Car car) {
        if (car.getN() == 1) {
            for (int i = 0; i < cars.length; i++) {
                if (Objects.equals(cars[i], car)) {
                    cars[i] = null;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < trucks.length; i++) {
                if (Objects.equals(trucks[i], car)) {
                    trucks[i] = null;
                    return true;
                }
            }
            for (int i = 0; i < cars.length; i++) {
                if (Objects.equals(cars[i], car)) {
                    int j = i + car.getN();
                    while (i < j) {
                        cars[i++] = null;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Метод возвращает количество машин на парковке для легковых машин.
     * @return Количество машин.
     */
    @Override
    public int numberCars() {
        int i = 0;
        int count = 0;
        while (i < cars.length) {
            if (cars[i] != null) {
                count++;
                i += cars[i].getN();
            } else {
                i++;
            }
        }
        return count;
    }

    /**
     * Метод возвращает количество машин на парковке для грузовых машин.
     * @return Количество машин.
     */
    @Override
    public int numberTrucks() {
        int count = 0;
        for (Car truck : trucks) {
            if (truck != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Метод проверяет, установлен ли на парковке автомобиль.
     * @param car Машина.
     * @return true, если машина есть на парковке, иначе false.
     */
    private boolean checkPark(Car car) {
        List<Car> c = Arrays.asList(cars);
        List<Car> t = Arrays.asList(trucks);
        return c.contains(car) || t.contains(car);
    }
}
