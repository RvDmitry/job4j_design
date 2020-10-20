package ru.job4j.design.lsp.parking;

/**
 * Class CarParking
 * Класс описывает парковку машин.
 * @author Dmitry Razumov
 * @version 1
 */
public class CarParking implements Parking {

    public CarParking(int c, int t) {

    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public boolean unpark(Car car) {
        return false;
    }

    @Override
    public int numberCars() {
        return 0;
    }

    @Override
    public int numberTrucks() {
        return 0;
    }
}
