package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {

    private Order order;
    private Lunch lunch;
    private Drink drink;

    @BeforeEach
    void setUp() {
        lunch = new Lunch(new MainCourse("Pierogi", 12f));
        drink = new Drink("Cola", 1.4f);
        order = new Order();
    }

    @Test
    void testIfGetDrinksContainsDrinkObject() {
        order.setDrinks(drink);
        assertTrue(order.getDrinks().contains(drink));
    }

    @Test
    void testIfsetDrinksWorksWithManyDrinks() {
        order.setDrinks(drink);
        order.setDrinks(drink);
        assertTrue(order.getDrinks().size() == 2);
    }

    @Test
    void testIfRemoveDrinkWorks() {
        order.setDrinks(drink);
        order.removeDrink(drink);
        assertTrue(order.getDrinks().size() == 0);
    }

    @Test
    void setLunchWorksWithMoreLunches() {
        order.setLunch(lunch);
        order.setLunch(lunch);
        assertTrue(order.getLunch().size() == 2);
    }

    @Test
    void getPriceCalculateCorrectly() {
        order.setDrinks(drink);
        order.setLunch(lunch);
        order.setLunch(lunch);
        assertTrue(order.getPrice() == 25.4f);
    }

}