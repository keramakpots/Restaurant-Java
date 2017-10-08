package DAO;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import model.Dessert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DaoDessertTest {

    private DaoDessert daoDessert;

    @BeforeEach
    void setUp() {
        daoDessert = new DaoDessert();
    }

    @Test
    void testIfGetDessertHashMapReturnHashMap() {
        assertTrue(daoDessert.getDessertHashMap().getClass().equals(HashMap.class));
    }

    @Test
    void testIfGetDessertHashMapContainsDessertsObjects() {
        assertTrue(daoDessert.getDessertHashMap().get(1).getClass().equals(Dessert.class));
    }

    @Test
    void testIfGetDessertReturnDessertObject() {
        daoDessert.getDessertHashMap();
        assertTrue(daoDessert.getDessert(1).getClass().equals(Dessert.class));
    }

}