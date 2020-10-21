package ru.job4j.design.lsp.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class CarParkingTest
 * Класс тестирует работу парковки.
 * @author Dmitry Razumov
 * @version 1
 */
public class CarParkingTest {
    /**
     * Метод тестирует установку легковой машины на парковку в случае успеха.
     */
    @Test
    public void whenCarParkThenTrue() {
        Car car = new Car("a123bc", 1);
        Parking parking = new CarParking(5, 5);
        assertTrue(parking.park(car));
    }

    /**
     * Метод тестирует установку легковой машины на парковку в случае неудачи.
     */
    @Test
    public void whenCarParkThenFalse() {
        Car first = new Car("a123bc", 1);
        Car second = new Car("c456ws", 1);
        Parking parking = new CarParking(1, 1);
        parking.park(first);
        assertFalse(parking.park(second));
    }

    /**
     * Метод проверяет, что нельзя поставить одну и ту же машину на парковку несколько раз.
     */
    @Test
    public void whenCarParkRepeat() {
        Car car = new Car("a123bc", 1);
        Parking parking = new CarParking(5, 5);
        assertTrue(parking.park(car));
        assertFalse(parking.park(car));
    }

    /**
     * Метод тестирует установку грузовой машины на парковку для грузовых машин в случае успеха.
     */
    @Test
    public void whenTruckParkToTruckParkingThenTrue() {
        Car truck = new Car("z111zx", 2);
        Parking parking = new CarParking(5, 5);
        assertTrue(parking.park(truck));
    }

    /**
     * Метод тестирует установку грузовой машины на парковку для легковых машин в случае успеха.
     */
    @Test
    public void whenTruckParkToCarParkingThenTrue() {
        Car first = new Car("z111zx", 2);
        Car second = new Car("w222aw", 2);
        Parking parking = new CarParking(5, 1);
        parking.park(first);
        assertTrue(parking.park(second));
    }

    /**
     * Метод тестирует установку грузовой машины на парковку в случае неудачи.
     */
    @Test
    public void whenTruckParkThenFalse() {
        Car first = new Car("a123bc", 1);
        Car second = new Car("w222aw", 2);
        Car third = new Car("c445fg", 2);
        Parking parking = new CarParking(2, 1);
        parking.park(first);
        parking.park(second);
        assertFalse(parking.park(third));
    }

    /**
     * Метод тестирует удаление легковой машины с парковки в случае успеха.
     */
    @Test
    public void whenCarUnparkThenTrue() {
        Car car = new Car("a123bc", 1);
        Parking parking = new CarParking(5, 5);
        parking.park(car);
        assertTrue(parking.unpark(car));
        assertThat(parking.numberCars(), is(0));
    }

    /**
     * Метод тестирует удаление легковой машины с парковки в случае неудачи.
     */
    @Test
    public void whenCarUnparkThenFalse() {
        Car car = new Car("a123bc", 1);
        Parking parking = new CarParking(5, 5);
        assertFalse(parking.unpark(car));
    }

    /**
     * Метод тестирует удаление грузовой машины с парковки для грузовых машин в случае успеха.
     */
    @Test
    public void whenTruckUnparkFromTruckParkingThenTrue() {
        Car truck = new Car("z111zx", 2);
        Parking parking = new CarParking(5, 5);
        parking.park(truck);
        assertTrue(parking.unpark(truck));
        assertThat(parking.numberTrucks(), is(0));
    }

    /**
     * Метод тестирует удаление грузовой машины с парковки для легковых машин в случае успеха.
     */
    @Test
    public void whenTruckUnparkFromCarParkingThenTrue() {
        Car first = new Car("z111zx", 2);
        Car second = new Car("w222aw", 2);
        Parking parking = new CarParking(5, 1);
        parking.park(first);
        parking.park(second);
        assertTrue(parking.unpark(second));
        assertThat(parking.numberCars(), is(0));
    }

    /**
     * Метод тестирует удаление грузовой машины в случае неудачи.
     */
    @Test
    public void whenTruckUnparkThenFalse() {
        Car truck = new Car("z111zx", 2);
        Parking parking = new CarParking(5, 5);
        assertFalse(parking.unpark(truck));
    }

    /**
     * Метод тестирует количество машин на парковке для легковых машин.
     */
    @Test
    public void whenNumberCarsThenOne() {
        Car car = new Car("a123bc", 1);
        Parking parking = new CarParking(5, 5);
        parking.park(car);
        assertThat(parking.numberCars(), is(1));
    }

    /**
     * Метод тестирует количество машин на парковке для грузовых машин.
     */
    @Test
    public void whenNumberTrucksThenOneTruckParking() {
        Car truck = new Car("z111zx", 2);
        Parking parking = new CarParking(5, 5);
        parking.park(truck);
        assertThat(parking.numberTrucks(), is(1));
    }

    /**
     * Метод тестирует количество грузовых машин на парковке для легковых машин.
     */
    @Test
    public void whenNumberTrucksThenOneCarParking() {
        Car first = new Car("z111zx", 2);
        Car second = new Car("w222aw", 2);
        Parking parking = new CarParking(5, 1);
        parking.park(first);
        parking.park(second);
        assertThat(parking.numberCars(), is(1));
    }
}