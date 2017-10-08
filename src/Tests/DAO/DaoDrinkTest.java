package DAO;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import model.Drink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DaoDrinkTest {

    private DaoDrink daoDrink;

    @BeforeEach
    void setUp() {
        daoDrink = new DaoDrink();
    }

    @Test
    void testIfGetDrinkHashMapReturnHashMap() {
        assertTrue(daoDrink.getDrinkHashMap().getClass().equals(HashMap.class));
    }

    @Test
    void testIfGetDrinkHashMapContainsDessertsObjects() {
        assertTrue(daoDrink.getDrinkHashMap().get(1).getClass().equals(Drink.class));
    }

    @Test
    void testIfGetDrinkReturnDessertObject() {
        daoDrink.getDrinkHashMap();
        assertTrue(daoDrink.getDrink(1).getClass().equals(Drink.class));
    }

}