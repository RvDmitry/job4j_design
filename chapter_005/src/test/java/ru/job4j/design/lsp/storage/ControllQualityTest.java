package ru.job4j.design.lsp.storage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.design.lsp.storage.model.*;
import ru.job4j.design.lsp.storage.store.Shop;
import ru.job4j.design.lsp.storage.store.Store;
import ru.job4j.design.lsp.storage.store.Trash;
import ru.job4j.design.lsp.storage.store.Warehouse;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class ControllQualityTest
 * Класс тестирует распределение продуктов по местам хранения.
 * @author Dmitry Razumov
 * @version 1
 */
public class ControllQualityTest {

    private List<Store> stores;

    @Before
    public void init() {
        stores = Arrays.asList(
                new Warehouse(),
                new Shop(),
                new Trash()
        );
    }

    @After
    public void clear() {
        new Shop().delete();
    }

    @Test
    public void whenFoodToWarehouse() {
        LocalDate creation = LocalDate.now().minusDays(2);
        LocalDate expiration = LocalDate.now().plusDays(8);
        List<Food> foods = Arrays.asList(new Dairy("Молоко", creation, expiration, 30));
        ControllQuality cq = new ControllQuality(stores);
        cq.sort(foods);
        assertThat(new Warehouse().get(), is(foods));
    }

    @Test
    public void whenFoodToShop() {
        LocalDate creation = LocalDate.now().minusDays(5);
        LocalDate expiration = LocalDate.now().plusDays(5);
        List<Food> foods = Arrays.asList(new Fruit("Слива", creation, expiration, 30));
        ControllQuality cq = new ControllQuality(stores);
        cq.sort(foods);
        assertThat(new Shop().get(), is(foods));
    }

    @Test
    public void whenFoodToTrash() {
        LocalDate creation = LocalDate.now().minusDays(4);
        LocalDate expiration = LocalDate.now().minusDays(1);
        List<Food> foods = Arrays.asList(new Bakery("Хлеб", creation, expiration, 30));
        ControllQuality cq = new ControllQuality(stores);
        cq.sort(foods);
        assertThat(new Trash().get(), is(foods));
    }

    @Test
    public void whenFoodToDisscount() {
        LocalDate creation = LocalDate.now().minusDays(8);
        LocalDate expiration = LocalDate.now().plusDays(2);
        Food food = new Vegetables("Томат", creation, expiration, 30);
        ControllQuality cq = new ControllQuality(stores);
        cq.sort(Arrays.asList(food));
        assertThat(new Shop().get().get(0).getDisscount(), is(food.getDisscount()));
    }

    @Test
    public void whenResort() {
        LocalDate creation = LocalDate.now().minusDays(1);
        LocalDate expiration = LocalDate.now().plusDays(10);
        Food milk = new Dairy("Молоко", creation, expiration, 50);
        ControllQuality cq = new ControllQuality(stores);
        cq.sort(Arrays.asList(milk));
        cq.resort();
        assertThat(new Warehouse().get().size(), is(1));
    }
}