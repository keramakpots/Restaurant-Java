package DAO;

import java.util.HashMap;
import java.util.List;
import model.MainCourse;
import util.Reader;

public class DaoMainDish {

    private static final String dishes = "MainDishes.txt";

    public static MainCourse getLunchFromCuisuine(String Cuisuine) {
        HashMap<String, MainCourse> mainCourseHashMap = new HashMap<>();
        List<String> dishesList = null;
        try {
            dishesList = Reader.readFile(dishes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String dishesData : dishesList) {
            String[] singleDishData = dishesData.split(",");
            MainCourse mainCourse = new MainCourse(singleDishData[1],
                Float.valueOf(singleDishData[2]));
            mainCourseHashMap.put(singleDishData[0], mainCourse);
        }
        return mainCourseHashMap.get(Cuisuine);
    }
}
