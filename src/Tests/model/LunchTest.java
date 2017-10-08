package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LunchTest {

    private MainCourse mainCourse;
    private Dessert dessert;
    private Lunch lunch;

    @BeforeEach
    void setUp() {
        dessert = new Dessert("Pudding", 2.5f);
        mainCourse = new MainCourse("PIEROGI", 5.0f);
    }

    @Test
    void testIfNewLunchIsWithEmptyDessert() {
        lunch = new Lunch(mainCourse);
        assertTrue(lunch.getDessert() == null);
    }

    @Test
    void testIfToStringMethodReturnCorrectString() {
        lunch = new Lunch(mainCourse);
        lunch.setDessert(dessert);
        String correct = "Main Dish:PIEROGI 5.0, Dessert Pudding 2.5";
        assertEquals(correct, lunch.toString());
    }

}