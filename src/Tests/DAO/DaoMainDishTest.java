package DAO;


import model.MainCourse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DaoMainDishTest {

    private final String cuisuine = "POLISH";
    private DaoMainDish daoMainDish;

    @BeforeEach
    void setUp() {
        daoMainDish = new DaoMainDish();
    }

    @Test
    void testIfdaoMainDishGetFunctionReturnCuisuineWithCorrectName() {
        MainCourse mainCourse = daoMainDish.getLunchFromCuisuine(cuisuine);
        Assertions.assertEquals(mainCourse.getName(), new MainCourse("PIEROGI", 5.0f).getName());
    }

    @Test
    void testIfdaoMainDishGetFunctionReturnCuisuineWithCorrectPrice() {
        MainCourse mainCourse = daoMainDish.getLunchFromCuisuine(cuisuine);
        Assertions.assertEquals(mainCourse.getPrice(), new MainCourse("PIEROGI", 5.0f).getPrice());
    }

    @Test
    void testIfdaoMainDishGetFunctionReturnDesiredClass() {
        MainCourse mainCourse = daoMainDish.getLunchFromCuisuine(cuisuine);
        Assertions.assertEquals(mainCourse.getClass(), new MainCourse("PIEROGI", 5.0f).getClass());
    }

}